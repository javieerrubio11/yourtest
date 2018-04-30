package com.yourtest.dao

import com.yourtest.entity.Answer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface AnswerRepository : JpaRepository<Answer, Long> {
    fun findByName(name: String): List<Answer>
    fun findByQuestion_Id(@Param("questionId") questionId: Long): List<Answer>
}