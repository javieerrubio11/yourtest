package com.yourtest.dao

import com.yourtest.entity.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository : JpaRepository<Users, Long>