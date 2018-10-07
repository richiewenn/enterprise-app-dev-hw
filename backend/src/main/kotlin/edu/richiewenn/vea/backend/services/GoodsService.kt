package edu.richiewenn.vea.backend.services

import edu.richiewenn.vea.backend.dao.GoodsRepository
import edu.richiewenn.vea.backend.dao.GoodsSaleRepository
import edu.richiewenn.vea.backend.models.Goods
import edu.richiewenn.vea.backend.models.GoodsSale
import edu.richiewenn.vea.backend.models.GoodsStock
import org.springframework.stereotype.Service

interface GoodsService {
  fun buy(id: Long, amount: Int)
  fun listStockStatus(): List<GoodsStock>
  fun checkStockStatus(id: Long): Int
  fun addProduct(goods: Goods): Goods
}

@Service
class GoodsServiceImpl(
  private val materialService: MaterialService,
  private val goodsRepository: GoodsRepository,
  private val goodsSaleRepository: GoodsSaleRepository
) : GoodsService {
  override fun addProduct(goods: Goods): Goods {
    return goodsRepository.save(goods)
  }

  override fun buy(id: Long, amount: Int) {
    if (this.checkStockStatus(id) < amount) {
      throw ClientException("Not enough goods at stock.")
    }
    val one = this.goodsRepository.findById(id).orElseThrow()
    val materialSales = one.requiredMaterials.entries.map {
      return@map materialService.buy(it.key, it.value * amount)
    }
    this.goodsSaleRepository.save(GoodsSale(
      goods = one,
      amount = amount,
      materialSales = materialSales
    ))
  }

  override fun listStockStatus(): List<GoodsStock> = TODO()

  override fun checkStockStatus(id: Long): Int = this.goodsRepository
    .findById(id).orElseThrow()
    .requiredMaterials.entries.map {
    val amount = materialService.checkStockStatus(it.key)
    return@map amount / it.value
  }.min() ?: 0
}
