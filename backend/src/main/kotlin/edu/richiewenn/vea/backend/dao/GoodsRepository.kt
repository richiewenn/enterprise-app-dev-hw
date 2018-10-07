package edu.richiewenn.vea.backend.dao

import edu.richiewenn.vea.backend.models.Goods
import org.springframework.data.repository.CrudRepository


interface GoodsRepository : CrudRepository<Goods, Long>

