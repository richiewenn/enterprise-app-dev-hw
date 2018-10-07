package edu.richiewenn.vea.ex4.models

import javax.persistence.*

@Entity
@Table(name = "material_stock")
data class MaterialStock(
  @Id
  @GeneratedValue
  val id: Long? = null,
  @OneToOne
  @JoinColumn(name = "material_id", referencedColumnName = "id")
  val material: Material,
  val stock: Int
)