package com.yourtest.config

import org.springframework.security.oauth2.provider.token.TokenEnhancerChain
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.provider.token.TokenEnhancer
import java.util.*

@Configuration
@EnableAuthorizationServer
class AuthorizationServerConfig : AuthorizationServerConfigurerAdapter() {

    @Value("\${security.jwt.client-id}")
    private val clientId: String? = null

    @Value("\${security.jwt.client-secret}")
    private val clientSecret: String? = null

    @Value("\${security.jwt.grant-type}")
    private val grantType: String? = null

    @Value("\${security.jwt.scope-read}")
    private val scopeRead: String? = null

    @Value("\${security.jwt.scope-write}")
    private val scopeWrite = "write"

    @Value("\${security.jwt.resource-ids}")
    private val resourceIds: String? = null

    @Autowired
    private val tokenStore: TokenStore? = null

    @Autowired
    private val accessTokenConverter: JwtAccessTokenConverter? = null

    @Autowired
    private val authenticationManager: AuthenticationManager? = null

    @Throws(Exception::class)
    override fun configure(configurer: ClientDetailsServiceConfigurer?) {
        configurer!!
                .inMemory()
                .withClient(clientId)
                .secret(clientSecret)
                .authorizedGrantTypes(grantType!!)
                .scopes(scopeRead, scopeWrite)
                .resourceIds(resourceIds!!)
    }

    @Throws(Exception::class)
    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer?) {
        val enhancerChain = TokenEnhancerChain()
        val listAccessTokenConverter = ArrayList<TokenEnhancer?>()
        listAccessTokenConverter.add(accessTokenConverter)
        enhancerChain.setTokenEnhancers(listAccessTokenConverter)
        endpoints!!.tokenStore(tokenStore)
                .accessTokenConverter(accessTokenConverter)
                .tokenEnhancer(enhancerChain)
                .authenticationManager(authenticationManager)
    }

}