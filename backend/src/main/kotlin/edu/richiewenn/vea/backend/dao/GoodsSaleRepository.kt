package edu.richiewenn.vea.backend.dao

import edu.richiewenn.vea.backend.models.GoodsSale
import org.springframework.data.repository.CrudRepository


interface GoodsSaleRepository : CrudRepository<GoodsSale, Long>

