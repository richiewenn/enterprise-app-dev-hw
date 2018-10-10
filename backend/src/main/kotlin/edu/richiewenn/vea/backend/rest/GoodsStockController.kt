package edu.richiewenn.vea.backend.rest

import edu.richiewenn.vea.api.rest.dtos.GoodsStockDTO
import edu.richiewenn.vea.api.rest.dtos.JsonResponse
import edu.richiewenn.vea.api.rest.dtos.JsonWrapper
import edu.richiewenn.vea.api.rest.dtos.MaterialStockDTO
import edu.richiewenn.vea.backend.rangeTo
import edu.richiewenn.vea.backend.rest.mappers.GoodsMapper
import edu.richiewenn.vea.backend.rest.mappers.MaterialMapper
import edu.richiewenn.vea.backend.services.GoodsService
import edu.richiewenn.vea.backend.services.MaterialService
import org.springframework.web.bind.annotation.*

@RestController()
@RequestMapping("/api/v1/stock/goods")
class GoodsStockController(
  private val goodsService: GoodsService
) {
  @GetMapping
  fun stock(): JsonResponse<List<GoodsStockDTO>> =
    goodsService.listStockStatus()
      .map(GoodsMapper::map)..
      JsonWrapper::wrap
}
