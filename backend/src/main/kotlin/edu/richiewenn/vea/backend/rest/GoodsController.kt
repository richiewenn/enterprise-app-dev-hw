package edu.richiewenn.vea.backend.rest

import edu.richiewenn.vea.api.rest.dtos.GoodsDTO
import edu.richiewenn.vea.api.rest.dtos.JsonWrapper
import edu.richiewenn.vea.backend.rangeTo
import edu.richiewenn.vea.backend.rest.mappers.GoodsMapper
import edu.richiewenn.vea.backend.services.GoodsService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/goods")
class GoodsController(
  private val goodsService: GoodsService
) {
  @PostMapping
  fun addProduct(@RequestBody goods: GoodsDTO) =
    goods ..
      GoodsMapper::map ..
      goodsService::addProduct ..
      GoodsMapper::map ..
      JsonWrapper::wrap
}

