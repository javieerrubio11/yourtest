package com.yourtest.service

import com.yourtest.dao.IUsersDAO
import com.yourtest.entity.Users
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class UsersService : IUsersService {

    @Autowired
    lateinit var usersDao : IUsersDAO

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