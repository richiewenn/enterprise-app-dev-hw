package edu.richiewenn.vea.ex4.dao

import edu.richiewenn.vea.ex4.models.MaterialSale
import org.springframework.data.repository.CrudRepository


interface MaterialSaleRepository : CrudRepository<MaterialSale, Long>

