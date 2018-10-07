package edu.richiewenn.vea.ex4.models

import javax.persistence.*

@Entity
@Table(name = "material", uniqueConstraints = [(UniqueConstraint(columnNames = ["name"]))])
data class Material(
  @Id
  @GeneratedValue
  val id: Long? = null,
  val name: String
)