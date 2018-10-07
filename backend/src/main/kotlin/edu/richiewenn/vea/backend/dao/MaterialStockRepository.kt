package edu.richiewenn.vea.backend.dao

import edu.richiewenn.vea.backend.models.MaterialStock
import org.springframework.data.repository.CrudRepository
import java.util.*


interface MaterialStockRepository : CrudRepository<MaterialStock, Long> {
  fun findByMaterialName(name: String): Optional<MaterialStock>
}