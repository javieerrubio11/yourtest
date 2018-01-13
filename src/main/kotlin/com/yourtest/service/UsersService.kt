package com.yourtest.service

import com.yourtest.entity.User

interface UsersService {
    fun getAllUsers() : List<User>
    fun insert(nombre : String) : User
    fun getOne(id : Long) : User
}