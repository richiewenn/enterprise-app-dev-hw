package edu.richiewenn.vea.frontend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect
import org.thymeleaf.spring5.SpringTemplateEngine
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver

@SpringBootApplication
class FrontendApp

fun main(args: Array<String>) {
  runApplication<FrontendApp>(*args)
}

@Configuration
class AppConfig {
  @Bean
  fun restTemplate() = RestTemplate()

  @Bean
  fun securityDialect(): SpringSecurityDialect {
    return SpringSecurityDialect()
  }
}

val backendBaseUrl = "http://localhost:8080/api/v1"