package com.yourtest.dao

import com.yourtest.entity.Quiz
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface QuizRepository : JpaRepository<Quiz, Long> {
    fun findByOwner_Username(@Param("ownerUsername") ownerUsername: String): List<Quiz>
}