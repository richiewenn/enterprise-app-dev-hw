package edu.richiewenn.vea.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer

@SpringBootApplication
@EnableJpaRepositories
@EnableOAuth2Sso
@EnableAuthorizationServer
@EnableResourceServer
class BackendApp

fun main(args: Array<String>) {
  runApplication<BackendApp>(*args)
}

/** Emulation of functional style chaining operator. Highly convenient and highly experimental. */
operator fun <T, R> T.rangeTo(f: (T) -> R): R {
  return f(this)
}