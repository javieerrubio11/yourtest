package com.yourtest.config

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

import com.yourtest.entity.Constants.HEADER_STRING
import com.yourtest.entity.Constants.TOKEN_PREFIX

class JwtAuthenticationFilter : OncePerRequestFilter() {

    @Autowired
    private val userDetailsService: UserDetailsService? = null

    @Autowired
    private val jwtTokenUtil: JwtTokenUtil? = null

    @Throws(IOException::class, ServletException::class)
    override fun doFilterInternal(req: HttpServletRequest, res: HttpServletResponse, chain: FilterChain) {
        val header = req.getHeader(HEADER_STRING)
        var username: String? = null
        var authToken: String? = null
        if (header != null && header.startsWith(TOKEN_PREFIX)) {
            authToken = header.replace(TOKEN_PREFIX, "")
            try {
                username = jwtTokenUtil!!.getUsernameFromToken(authToken)
            } catch (e: IllegalArgumentException) {
                logger.error("an error occured during getting username from token", e)
            } catch (e: ExpiredJwtException) {
                logger.warn("the token is expired and not valid anymore", e)
            } catch (e: SignatureException) {
                logger.error("Authentication Failed. Username or Password not valid.")
            }

        } else {
            logger.warn("couldn't find bearer string, will ignore the header")
        }
        if (username != null && SecurityContextHolder.getContext().authentication == null) {

            val userDetails = userDetailsService!!.loadUserByUsername(username)

            if (jwtTokenUtil!!.validateToken(authToken!!, userDetails)!!) {
                val authentication = UsernamePasswordAuthenticationToken(userDetails, null, Arrays.asList(SimpleGrantedAuthority("ROLE_ADMIN")))
                authentication.details = WebAuthenticationDetailsSource().buildDetails(req)
                logger.info("authenticated user $username, setting security context")
                SecurityContextHolder.getContext().authentication = authentication
            }
        }

        chain.doFilter(req, res)
    }
}