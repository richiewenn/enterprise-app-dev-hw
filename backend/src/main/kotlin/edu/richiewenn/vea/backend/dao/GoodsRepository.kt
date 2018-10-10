package edu.richiewenn.vea.backend.dao

import edu.richiewenn.vea.backend.models.Goods
import org.springframework.data.repository.CrudRepository
import java.util.*


interface GoodsRepository : CrudRepository<Goods, Long> {
  fun findOneByName(name: String): Optional<Goods>
}

