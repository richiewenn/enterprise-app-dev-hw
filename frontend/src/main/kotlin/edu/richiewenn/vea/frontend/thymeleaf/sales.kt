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
class SalesController(
  private val restTemplate: RestTemplate
) {
  @RequestMapping("/sales")
  fun sales(model: MutableMap<String, Any?>): String {
    model["goodSales"] = restTemplate
      .getForObject<JsonResponse<List<GoodsSaleDTO>>>("$backendBaseUrl/sales/goods")
      ?.data
    return "sales"
  }

}