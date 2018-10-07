package edu.richiewenn.vea.backend.rest

import edu.richiewenn.vea.api.rest.dtos.JsonResponse
import edu.richiewenn.vea.api.rest.dtos.JsonWrapper
import edu.richiewenn.vea.api.rest.dtos.MaterialStockDTO
import edu.richiewenn.vea.backend.rangeTo
import edu.richiewenn.vea.backend.rest.mappers.MaterialMapper
import edu.richiewenn.vea.backend.services.MaterialService
import org.springframework.web.bind.annotation.*

@RestController()
@RequestMapping("/api/v1/stock/materials")
class MaterialStockController(
  private val materialService: MaterialService
) {
  @PostMapping
  fun addToStock(@RequestBody material: MaterialStockDTO) =
    material..
      MaterialMapper::map..
      materialService::addToStock..
      MaterialMapper::map..
      JsonWrapper::wrap

  @GetMapping
  fun stock(): JsonResponse<List<MaterialStockDTO>> =
    materialService.listStockStatus()
      .map(MaterialMapper::map)..
      JsonWrapper::wrap

}
