package edu.richiewenn.vea.ex4.thymeleaf

import edu.richiewenn.vea.ex4.models.Material
import edu.richiewenn.vea.ex4.models.MaterialStock
import edu.richiewenn.vea.ex4.services.GoodsService
import edu.richiewenn.vea.ex4.services.MaterialService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView


@Controller
class StockController(
  private val goodsService: GoodsService,
  private val materialService: MaterialService
) {
  @RequestMapping("/stock")
  fun stock(model: MutableMap<String, Any>): String {
    model["materialsInStock"] = this.materialService.listStockStatus()
    return "stock"
  }
  @PostMapping("/add-to-stock")
  fun addToStock(@RequestParam params: Map<String, String>): ModelAndView {
    this.materialService.addToStock(MaterialStock(
      stock = Integer.valueOf(params["amount"]),
      material = Material(
        name = params["name"]!!
      )
    ))
    return ModelAndView("redirect:/stock")
  }
}