package edu.richiewenn.vea.api.rest.dtos

data class MaterialStockDTO(
  val id: Long? = null,
  val material: MaterialDTO,
  val stock: Int
)