package com.yourtest.controller

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User

abstract class BaseController {

    fun getUsername() : String {
        val auth = SecurityContextHolder.getContext().authentication
        val principal = auth.principal as User
        return principal.username
    }

}