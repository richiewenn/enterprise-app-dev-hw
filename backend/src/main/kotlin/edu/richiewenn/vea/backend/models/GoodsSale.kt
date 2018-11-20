package edu.richiewenn.vea.backend.models

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "goods_sale")
data class GoodsSale(
  @Id
  @GeneratedValue
  val id: Long? = null,
  @ManyToOne
  @JoinColumn(name = "goods_id", referencedColumnName = "id")
  val goods: Goods,
  val amount: Int,
  @OneToMany
  @JoinColumn(name = "goods_sale_id", referencedColumnName = "id")
  val materialSales: List<MaterialSale>,
  @Basic(optional = true)
  @Column(name = "sold", insertable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  val sold: Date? = null
)