package edu.richiewenn.vea.ex4.rest

import edu.richiewenn.vea.ex4.rest.dtos.JsonResponse
import edu.richiewenn.vea.ex4.models.MaterialStock
import edu.richiewenn.vea.ex4.services.MaterialService
import org.springframework.web.bind.annotation.*

@RestController()
@RequestMapping("/api/v1/stock/materials")
class MaterialStockController(
  private val materialService: MaterialService
) {
  @PostMapping
  fun addToStock(@RequestBody material: MaterialStock): MaterialStock {
    return this.materialService.addToStock(material)
  }

  @GetMapping
  fun stock(): JsonResponse<List<MaterialStock>> = JsonResponse(
    data = this.materialService.listStockStatus()
  )

}
