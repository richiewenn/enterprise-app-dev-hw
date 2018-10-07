package edu.richiewenn.vea.ex4.models

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "material_sale")
data class MaterialSale(
  @Id
  @GeneratedValue
  val id: Long? = null,
  @ManyToOne
  @JoinColumn(name = "material_id", referencedColumnName = "id")
  val material: Material,
  val amount: Int,
  @Basic(optional = false)
  @Column(name = "sold", insertable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  val sold: Date? = null
)