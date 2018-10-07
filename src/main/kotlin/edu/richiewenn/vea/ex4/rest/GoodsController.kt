package edu.richiewenn.vea.ex4.rest

import edu.richiewenn.vea.ex4.models.Goods
import edu.richiewenn.vea.ex4.models.GoodsStock
import edu.richiewenn.vea.ex4.rest.dtos.JsonResponse
import edu.richiewenn.vea.ex4.services.GoodsService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/goods")
class GoodsController(
  private val goodsService: GoodsService
) {
  @PostMapping
  fun addProduct(@RequestBody stock: Goods): JsonResponse<Goods> {
    return JsonResponse(
      data = this.goodsService.addProduct(stock)
    )
  }
}
