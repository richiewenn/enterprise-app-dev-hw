package edu.richiewenn.vea.backend.models


/**
 * @param requiredMaterials <Goods, Amount> to make this Goods
 */
data class GoodsStock(
  val goods: Goods,
  val stock: Int
)