package edu.richiewenn.vea.api.rest.dtos

import java.util.*

data class GoodsSaleDTO(
  val id: Long? = null,
  val goods: GoodsDTO,
  val amount: Int,
  val materialSales: List<MaterialSaleDTO>,
  val sold: Date? = null
)