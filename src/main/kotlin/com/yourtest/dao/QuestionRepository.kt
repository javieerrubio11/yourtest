package com.yourtest.dao

import com.yourtest.entity.Question
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface QuestionRepository : CrudRepository<Question, Long>, JpaRepository<Question, Long> {

    fun findByNombre(nombre: String): List<Question>

}