//package edu.richiewenn.vea.backend
//
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
//import org.springframework.security.authentication.AuthenticationManager
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
//import org.springframework.stereotype.Component
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
//
//
//
//
//@Component
//class CustomAuthorizationServerConfigurer @Throws(Exception::class)
//constructor(
//  authenticationConfiguration: AuthenticationConfiguration
//) : AuthorizationServerConfigurerAdapter() {
//
//  var authenticationManager: AuthenticationManager? = null
//
//  init {
//    this.authenticationManager = authenticationConfiguration.authenticationManager
//  }
//
//  @Throws(Exception::class)
//  override fun configure(
//    clients: ClientDetailsServiceConfigurer?
//  ) {
//    clients!!.inMemory()
//      .withClient("acme")
//      .authorizedGrantTypes("password")
//      .secret("acmesecret")
//      .scopes("all")
//  }
//
//  @Throws(Exception::class)
//  override fun configure(
//    endpoints: AuthorizationServerEndpointsConfigurer?
//  ) {
//    endpoints!!.authenticationManager(authenticationManager)
//  }
//  @Throws(Exception::class)
//  override fun configure(oauthServer: AuthorizationServerSecurityConfigurer?) {
//    oauthServer!!.allowFormAuthenticationForClients()
//  }
//}