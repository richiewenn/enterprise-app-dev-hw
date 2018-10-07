package edu.richiewenn.vea.ex4.dao

import edu.richiewenn.vea.ex4.models.Goods
import edu.richiewenn.vea.ex4.models.Material
import org.springframework.data.repository.CrudRepository


interface GoodsRepository : CrudRepository<Goods, Long>

