package com.yourtest.controller

import com.yourtest.config.JwtTokenUtil;
import com.yourtest.entity.AuthToken;
import com.yourtest.entity.User;
import com.yourtest.service.UsersService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = arrayOf("*"), maxAge = 3600)
@RestController
@RequestMapping("/token")
class AuthenticationController {

    @Autowired
    private val authenticationManager: AuthenticationManager? = null

    @Autowired
    private val jwtTokenUtil: JwtTokenUtil? = null

    @Autowired
    private val userService: UsersService? = null

    @RequestMapping(value = "/generate-token", method = arrayOf(RequestMethod.POST))
    @Throws(AuthenticationException::class)
    fun register(@RequestBody loginUser: User): ResponseEntity<*> {

        val authentication = authenticationManager!!.authenticate(
                UsernamePasswordAuthenticationToken(
                        loginUser.username,
                        loginUser.password
                )
        )
        SecurityContextHolder.getContext().authentication = authentication
        val user = userService!!.getByUsername(loginUser.username)
        val token = jwtTokenUtil!!.generateToken(user)
        return ResponseEntity.ok<Any>(AuthToken(token))
    }

}