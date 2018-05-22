package com.yourtest.service.impl

import com.yourtest.dao.UserRepository
import com.yourtest.entity.User
import com.yourtest.service.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class UsersServiceImpl : UsersService {

    @Autowired
    lateinit var usersDao : UserRepository

    override fun getAllUsers() : List<User> {
        return usersDao.findAll()
    }

    override fun insert(nombre: String): User {
        val user = User(0, nombre, "","")
        try {
            return usersDao.save(user)
        } catch (e : Exception) {
            e.printStackTrace()
            throw Exception(e.localizedMessage)
        }
    }

    override fun getOne(id: Long): User {
        return usersDao.getOne(id)
    }

    override fun getByUsername(username : String): User {
        return usersDao.findByUsername(username)
    }
}