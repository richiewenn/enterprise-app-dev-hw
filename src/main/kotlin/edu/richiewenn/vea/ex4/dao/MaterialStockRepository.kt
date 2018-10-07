package edu.richiewenn.vea.ex4.dao

import edu.richiewenn.vea.ex4.models.Material
import edu.richiewenn.vea.ex4.models.MaterialStock
import org.springframework.data.repository.CrudRepository
import java.util.*


interface MaterialStockRepository : CrudRepository<MaterialStock, Long> {
  fun findByMaterialName(name: String): Optional<MaterialStock>
}