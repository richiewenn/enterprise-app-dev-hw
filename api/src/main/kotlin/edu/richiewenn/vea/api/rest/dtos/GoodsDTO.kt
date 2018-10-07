package edu.richiewenn.vea.api.rest.dtos

/**
 * @param requiredMaterials <GoodsName, Amount> to make this Goods
 */
data class GoodsDTO(
  val id: Long? = null,
  val name: String,
  val requiredMaterials: Map<String, Int> = HashMap()
)