package com.yourtest.dao

import com.yourtest.entity.Question
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface QuestionRepository : JpaRepository<Question, Long> {
    fun findByName(name: String): List<Question>

//    @Query("SELECT * FROM question q where q.quiz_id = :quizId", nativeQuery=true)
//    @Query("SELECT q FROM Question q where q.quiz.id = :quizId")
    fun findByQuiz_Id(@Param("quizId") quizId: Long): List<Question>
}