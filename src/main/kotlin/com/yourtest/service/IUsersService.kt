package com.yourtest.service

import com.yourtest.entity.Users

interface IUsersService {
    fun getAllUsers() : List<Users>
    fun insert(nombre : String) : Users
}