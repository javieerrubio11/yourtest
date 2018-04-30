package com.yourtest.controller

import com.yourtest.entity.User
import com.yourtest.service.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
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