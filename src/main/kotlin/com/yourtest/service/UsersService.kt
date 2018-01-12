package com.yourtest.service

import com.yourtest.entity.Users

interface UsersService {
    fun getAllUsers() : List<Users>
    fun insert(nombre : String) : Users
}