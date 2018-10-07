package edu.richiewenn.vea.ex4.models

import javax.persistence.*

/**
 * @param requiredMaterials <Goods, Amount> to make this Goods
 */
@Entity
@Table(name = "goods_stock")
data class GoodsStock(
  @Id
  @GeneratedValue
  val id: Long?,
  @OneToOne
  @JoinColumn(name = "goods_id", referencedColumnName = "id")
  val goods: Goods,
  val stock: Int
)