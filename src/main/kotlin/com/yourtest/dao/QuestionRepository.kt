package com.yourtest.dao

import com.yourtest.entity.Question
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface QuestionRepository : JpaRepository<Question, Long> {
    fun findByName(nombre: String): List<Question>
}