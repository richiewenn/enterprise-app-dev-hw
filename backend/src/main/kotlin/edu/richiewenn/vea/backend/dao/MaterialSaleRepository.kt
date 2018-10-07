package edu.richiewenn.vea.backend.dao

import edu.richiewenn.vea.backend.models.MaterialSale
import org.springframework.data.repository.CrudRepository


interface MaterialSaleRepository : CrudRepository<MaterialSale, Long>

