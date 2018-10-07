package edu.richiewenn.vea.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class BackendApp

fun main(args: Array<String>) {
  runApplication<BackendApp>(*args)
}

/** Emulation of functional style chaining operator. Highly convenient and highly experimental. */
operator fun <T, R> T.rangeTo(f: (T) -> R): R {
  return f(this)
}