package edu.richiewenn.vea.backend.services

import edu.richiewenn.vea.backend.dao.GoodsRepository
import edu.richiewenn.vea.backend.dao.GoodsSaleRepository
import edu.richiewenn.vea.api.rest.dtos.BuyGoodsDTO
import edu.richiewenn.vea.backend.models.Goods
import edu.richiewenn.vea.backend.models.GoodsSale
import edu.richiewenn.vea.backend.models.GoodsStock
import org.springframework.stereotype.Service

interface GoodsService {
  fun buy(goods: BuyGoodsDTO): GoodsSale
  fun listStockStatus(): List<GoodsStock>
  fun checkStockStatus(name: String): Int
  fun addProduct(goods: Goods): Goods
  fun getAllGoods(): List<Goods>
  fun getSales(): List<GoodsSale>
  fun updateProduct(goods: Goods): Goods
  fun deleteProduct(id: Long)
}

@Service
class GoodsServiceImpl(
  private val materialService: MaterialService,
  private val goodsRepository: GoodsRepository,
  private val goodsSaleRepository: GoodsSaleRepository
) : GoodsService {

  override fun deleteProduct(id: Long) {
    goodsRepository.deleteById(id)
  }

  override fun getSales(): List<GoodsSale> = goodsSaleRepository.findAll().toList()

  override fun getAllGoods(): List<Goods> = goodsRepository.findAll().toList()

  override fun addProduct(goods: Goods): Goods {
    return goodsRepository.save(goods)
  }

  override fun updateProduct(goods: Goods): Goods {
    return goodsRepository.save(goods)
  }

  override fun buy(goods: BuyGoodsDTO): GoodsSale {
    if (this.checkStockStatus(goods.name) < goods.amount) {
      throw ClientException("Not enough goods at stock.")
    }
    val one = this.goodsRepository.findOneByName(goods.name).orElseThrow()
    val materialSales = one.requiredMaterials.entries.map {
      return@map materialService.buy(it.key, it.value * goods.amount)
    }
    return this.goodsSaleRepository.save(GoodsSale(
      goods = one,
      amount = goods.amount,
      materialSales = materialSales
    ))
  }

  override fun listStockStatus(): List<GoodsStock> = goodsRepository
    .findAll()
    .map { goods ->
      GoodsStock(
        goods = goods,
        stock = goods.requiredMaterials.entries
          .asSequence()
          .map { materialService.checkStockStatus(it.key) / it.value }
          .min() ?: 0
      )
    }

  override fun checkStockStatus(name: String): Int = this.goodsRepository
    .findOneByName(name).orElseThrow()
    .requiredMaterials.entries
    .asSequence()
    .map { materialService.checkStockStatus(it.key) / it.value }
    .min() ?: 0
}
