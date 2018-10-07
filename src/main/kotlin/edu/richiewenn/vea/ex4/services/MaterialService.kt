package edu.richiewenn.vea.ex4.services

import edu.richiewenn.vea.ex4.dao.MaterialRepository
import edu.richiewenn.vea.ex4.dao.MaterialSaleRepository
import edu.richiewenn.vea.ex4.dao.MaterialStockRepository
import edu.richiewenn.vea.ex4.models.MaterialSale
import edu.richiewenn.vea.ex4.models.MaterialStock
import org.springframework.stereotype.Service

interface MaterialService {
  fun buy(name: String, amount: Int): MaterialSale
  fun addToStock(stock: MaterialStock): MaterialStock
  fun listStockStatus(): List<MaterialStock>
  fun checkStockStatus(name: String): Int
}

@Service
class MaterialServiceImpl(
  private val materialStockRepository: MaterialStockRepository,
  private val materialSaleRepository: MaterialSaleRepository,
  private val materialRepository: MaterialRepository
) : MaterialService {
  override fun addToStock(stock: MaterialStock): MaterialStock {
    this.materialRepository.save(stock.material)
    return this.materialStockRepository.save(stock)
  }

  override fun listStockStatus(): List<MaterialStock> = this.materialStockRepository.findAll().toList()

  override fun buy(name: String, amount: Int): MaterialSale {
    val one = this.materialStockRepository.findByMaterialName(name).orElseThrow()
    val newAmount = one.stock - amount
    if (newAmount < 0) {
      throw ClientException("Not enough material $name at stock")
    }
    this.materialStockRepository.save(one.copy(
      stock = newAmount
    ))
    return this.materialSaleRepository.save(MaterialSale(
      amount = amount,
      material = one.material
    ))
  }

  override fun checkStockStatus(name: String): Int = this.materialStockRepository.findByMaterialName(name).map { it.stock }.orElseThrow()

}