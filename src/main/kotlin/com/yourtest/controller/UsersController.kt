package com.yourtest.controller

import com.yourtest.dao.IUsersDAO
import com.yourtest.entity.Users
import com.yourtest.service.IUsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UsersController (val usersDao: IUsersDAO) {
    @Autowired
    lateinit var usersService : IUsersService

    @GetMapping(value = "/all")
    fun getUsers() = usersDao.findAll()

    @GetMapping(value = "/insert/{nombre}")
    fun insertUsers(@PathVariable nombre: String) : List<Users> {
        usersService.insert(nombre)
        return usersService.getAllUsers()
    }

    @GetMapping(value = "/get/{id}")
    fun getUsers(@PathVariable id: Long) : Users {
        return usersDao.getOne(id)
    }
}