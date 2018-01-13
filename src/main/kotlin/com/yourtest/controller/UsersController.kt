package com.yourtest.controller

import com.yourtest.entity.User
import com.yourtest.service.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UsersController {
    @Autowired
    lateinit var usersService : UsersService

    @GetMapping(value = "/all")
    fun getUsers() : List<User> {
        return usersService.getAllUsers()
    }

    @GetMapping(value = "/insert/{nombre}")
    fun insertUsers(@PathVariable nombre: String) : List<User> {
        usersService.insert(nombre)
        return usersService.getAllUsers()
    }

    @GetMapping(value = "/get/{id}")
    fun getUsers(@PathVariable id: Long) : User {
        return usersService.getOne(id)
    }
}