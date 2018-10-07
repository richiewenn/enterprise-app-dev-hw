package edu.richiewenn.vea.ex4.models

import javax.persistence.*

/**
 * @param requiredMaterials <GoodsName, Amount> to make this Goods
 */
@Entity
@Table(name = "goods", uniqueConstraints = [(UniqueConstraint(columnNames = ["name"]))])
data class Goods(
  @Id
  @GeneratedValue
  val id: Long? = null,
  val name: String,
  @ElementCollection
  @MapKeyColumn(name="material_name") 
  @Column(name="amount")
  @CollectionTable(name="required_materials", joinColumns=[JoinColumn(name="required_material_id")])
  val requiredMaterials: Map<String, Int> = HashMap()
)