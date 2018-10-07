package edu.richiewenn.vea.api.rest.dtos

/**
 * @param requiredMaterials <Goods, Amount> to make this Goods
 */
data class GoodsStockDTO(
  val id: Long?,
  val goods: GoodsDTO,
  val stock: Int
)