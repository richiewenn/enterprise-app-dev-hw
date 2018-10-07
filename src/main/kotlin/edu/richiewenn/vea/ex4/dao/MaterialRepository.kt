package edu.richiewenn.vea.ex4.dao

import edu.richiewenn.vea.ex4.models.Material
import org.springframework.data.repository.CrudRepository

interface MaterialRepository : CrudRepository<Material, Long> {
}