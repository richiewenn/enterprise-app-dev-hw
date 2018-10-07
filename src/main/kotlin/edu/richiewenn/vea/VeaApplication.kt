package edu.richiewenn.vea

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class VeaApplication

fun main(args: Array<String>) {
  runApplication<VeaApplication>(*args)
}
