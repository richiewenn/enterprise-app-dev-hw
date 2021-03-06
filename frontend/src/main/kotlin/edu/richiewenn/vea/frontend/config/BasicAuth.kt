package edu.richiewenn.vea.frontend.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.client.RestTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


@EnableGlobalMethodSecurity(securedEnabled=true)
@Configuration
@EnableWebSecurity
class CustomWebSecurityConfigurerAdapter(
  private val restTemplate: RestTemplate
) : WebSecurityConfigurerAdapter() {


  @Autowired
  private val encoder: PasswordEncoder? = null
  @Throws(Exception::class)
  override fun configure(auth: AuthenticationManagerBuilder?) {
    auth!!.inMemoryAuthentication()
      .withUser("user").password(encoder!!.encode("user")).roles("USER")
      .and()
      .withUser("sales").password(encoder.encode("sales")).roles("USER", "SALES")
      .and()
      .withUser("management").password(encoder.encode("management")).roles("USER", "MANAGEMENT")
      .and()
      .withUser("purchasing").password(encoder.encode("purchasing")).roles("USER", "PURCHASING")
  }

  @Throws(Exception::class)
  override fun configure(http: HttpSecurity) {
    http
      .authorizeRequests()
      .antMatchers("/", "/api/**").hasRole("USER")
      .anyRequest().authenticated()
      .and()
      .formLogin()
      .loginPage("/login")
      .successForwardUrl("/hello")
      .permitAll()
      .and()
      .logout()
      .permitAll()
  }

  @Bean
  fun passwordEncoder(): PasswordEncoder {
    return BCryptPasswordEncoder()
  }
}