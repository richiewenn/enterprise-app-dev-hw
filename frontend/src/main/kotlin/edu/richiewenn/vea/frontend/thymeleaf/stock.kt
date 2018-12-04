package edu.richiewenn.vea.frontend.thymeleaf

import edu.richiewenn.vea.api.rest.dtos.JsonResponse
import edu.richiewenn.vea.api.rest.dtos.MaterialDTO
import edu.richiewenn.vea.api.rest.dtos.MaterialStockDTO
import edu.richiewenn.vea.frontend.backendBaseUrl
import org.springframework.core.ParameterizedTypeReference
import org.springframework.security.access.annotation.Secured
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import org.springframework.web.client.postForObject
import org.springframework.web.servlet.ModelAndView


@Controller
class StockController(
  private val restTemplate: RestTemplate
) {
  @RequestMapping("/stock")
  fun stock(model: MutableMap<String, Any?>): String {
    model["materialsInStock"] = restTemplate
      .getForObject<JsonResponse<List<MaterialStockDTO>>>("$backendBaseUrl/stock/materials")
      ?.data
    return "stock"
  }

  @Secured("ROLE_PURCHASING")
  @PostMapping("/add-to-stock")
  fun addToStock(@RequestParam params: Map<String, String>): ModelAndView {
    restTemplate.postForObject<JsonResponse<MaterialStockDTO>>("$backendBaseUrl/stock/materials", MaterialStockDTO(
      stock = Integer.valueOf(params["amount"]),
      material = MaterialDTO(
        name = params["name"]!!
      )
    ))
    return ModelAndView("redirect:/stock")
  }
}