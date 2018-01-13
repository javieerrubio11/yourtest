package com.yourtest.service.impl

import com.yourtest.dao.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.util.ArrayList
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AppUserDetailsService : UserDetailsService {
    @Autowired
    lateinit var userRepository: UserRepository

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(s: String): UserDetails {
        val user = userRepository.findByUsername(s) ?: throw UsernameNotFoundException(String.format("The username %s doesn't exist", s))

        val authorities = ArrayList<GrantedAuthority>()
        user.roles.forEach { role -> authorities.add(SimpleGrantedAuthority(role.roleName)) }

        return User(user.username, user.password, authorities)
    }
}