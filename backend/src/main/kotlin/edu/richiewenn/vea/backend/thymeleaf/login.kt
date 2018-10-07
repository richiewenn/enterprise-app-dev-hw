package edu.richiewenn.vea.backend.thymeleaf

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class LoginController {
  @RequestMapping("/login")
  fun login(model: MutableMap<String, Any>): String {
    return "login"
  }
  @RequestMapping("/hello")
  fun hello(model: MutableMap<String, Any>): String {
    return "hello"
  }

}