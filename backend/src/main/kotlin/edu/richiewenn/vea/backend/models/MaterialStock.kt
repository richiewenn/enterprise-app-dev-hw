package edu.richiewenn.vea.backend.models

import javax.persistence.*

@Entity
@Table(name = "material_stock", uniqueConstraints = [(UniqueConstraint(columnNames = ["material_id"]))])
data class MaterialStock(
  @Id
  @GeneratedValue
  val id: Long? = null,
  @OneToOne
  @JoinColumn(name = "material_id", referencedColumnName = "id")
  val material: Material,
  val stock: Int
)