package edu.richiewenn.vea.frontend.thymeleaf

import edu.richiewenn.vea.api.rest.dtos.*
import edu.richiewenn.vea.frontend.backendBaseUrl
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import org.springframework.web.client.postForObject
import org.springframework.web.servlet.ModelAndView


@Controller
class GoodsController(
  private val restTemplate: RestTemplate
) {
  @RequestMapping("/goods")
  fun goods(model: MutableMap<String, Any?>): String {
    model["goodsStock"] = restTemplate
      .getForObject<JsonResponse<List<GoodsStockDTO>>>("$backendBaseUrl/stock/goods")
      ?.data
    return "goods"
  }

  @PostMapping("/add-product")
  fun addProduct(@RequestParam params: Map<String, String>): ModelAndView {
    restTemplate.postForObject<JsonResponse<GoodsStockDTO>>("$backendBaseUrl/goods", GoodsDTO(
      name = params["name"]!!,
      requiredMaterials = hashMapOf(Pair(params["materialName"]!!, Integer.valueOf(params["materialAmount"])))
    ))
    return ModelAndView("redirect:/goods")
  }

  @PostMapping("/buy-product")
  fun buyProduct(@RequestParam params: Map<String, String>): ModelAndView {
    val buy = BuyGoodsDTO(
      name = params["name"]!!,
      amount = Integer.valueOf(params["amount"])
    )
    restTemplate.postForObject<JsonResponse<MaterialStockDTO>>("$backendBaseUrl/sales/goods", buy)
    return ModelAndView("redirect:/sales")
  }
}