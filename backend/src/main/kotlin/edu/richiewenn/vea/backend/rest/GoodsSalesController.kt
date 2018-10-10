package edu.richiewenn.vea.backend.rest

import edu.richiewenn.vea.api.rest.dtos.*
import edu.richiewenn.vea.backend.models.BuyGoods
import edu.richiewenn.vea.backend.rangeTo
import edu.richiewenn.vea.backend.rest.mappers.GoodsMapper
import edu.richiewenn.vea.backend.rest.mappers.MaterialMapper
import edu.richiewenn.vea.backend.services.GoodsService
import edu.richiewenn.vea.backend.services.MaterialService
import org.springframework.web.bind.annotation.*

@RestController()
@RequestMapping("/api/v1/sales/goods")
class GoodsSalesController(
  private val goodsService: GoodsService
) {
  @PostMapping
  fun buy(goods: BuyGoods): JsonResponse<GoodsSaleDTO> =
    goods..
      goodsService::buy..
      GoodsMapper::map..
      JsonWrapper::wrap

  @GetMapping
  fun stock(): JsonResponse<List<GoodsSaleDTO>> =
    goodsService.getSales()
      .map(GoodsMapper::map)..
      JsonWrapper::wrap
}
