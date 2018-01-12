package com.yourtest.service.impl

import com.yourtest.dao.UsersRepository
import com.yourtest.entity.Users
import com.yourtest.service.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class UsersServiceImpl : UsersService {

    @Autowired
    lateinit var usersDao : UsersRepository

    override fun getAllUsers() : List<Users> {
        return usersDao.findAll()
    }

    override fun insert(nombre: String): Users {
        val user = Users(0, nombre, "","")
        try {
            return usersDao.save(user)
        } catch (e : Exception) {
            e.printStackTrace()
            throw Exception(e.localizedMessage)
        }
    }
}