package com.yourtest.service

import com.yourtest.entity.Question

interface QuestionService {
    fun getAll() : List<Question>
    fun getOne(id : Long) : Question
    fun insert(question : Question) : Question
    fun delete(id : Long)
    fun listByName(name : String) : List<Question>
    fun listByQuizId(quizId : Long) : List<Question>
}