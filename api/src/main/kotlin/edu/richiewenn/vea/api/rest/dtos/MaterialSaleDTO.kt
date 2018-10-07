package edu.richiewenn.vea.api.rest.dtos

import java.util.*

data class MaterialSaleDTO(
  val id: Long? = null,
  val material: MaterialDTO,
  val amount: Int,
  val sold: Date? = null
)