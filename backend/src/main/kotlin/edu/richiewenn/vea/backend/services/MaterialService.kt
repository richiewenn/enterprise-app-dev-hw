package edu.richiewenn.vea.backend.services

import ch.qos.logback.core.net.server.Client
import edu.richiewenn.vea.backend.dao.MaterialRepository
import edu.richiewenn.vea.backend.dao.MaterialSaleRepository
import edu.richiewenn.vea.backend.dao.MaterialStockRepository
import edu.richiewenn.vea.backend.models.MaterialSale
import edu.richiewenn.vea.backend.models.MaterialStock
import org.springframework.stereotype.Service

interface MaterialService {
  fun buy(name: String, amount: Int): MaterialSale
  fun addToStock(stock: MaterialStock): MaterialStock
  fun listStockStatus(): List<MaterialStock>
  fun checkStockStatus(name: String): Int
  fun deleteStock(id: Long)
  fun updateStock(stock: MaterialStock): MaterialStock
}

@Service
class MaterialServiceImpl(
  private val materialStockRepository: MaterialStockRepository,
  private val materialSaleRepository: MaterialSaleRepository,
  private val materialRepository: MaterialRepository
) : MaterialService {
  override fun deleteStock(id: Long) {
    materialStockRepository.deleteById(id)
  }

  override fun addToStock(stock: MaterialStock): MaterialStock {
    this.materialStockRepository.findByMaterialName(stock.material.name).ifPresent {
      throw ClientException("This material already exists in stock.")
    }
    this.materialRepository.save(stock.material)
    return this.materialStockRepository.save(stock)
  }

  override fun updateStock(stock: MaterialStock): MaterialStock {
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

  override fun checkStockStatus(name: String): Int = this.materialStockRepository.findByMaterialName(name).map { it.stock }.orElse(0)

}