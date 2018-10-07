package edu.richiewenn.vea.backend.dao

import edu.richiewenn.vea.backend.models.Material
import org.springframework.data.repository.CrudRepository

interface MaterialRepository : CrudRepository<Material, Long> {
}