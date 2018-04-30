package com.yourtest.service

import com.yourtest.entity.Answer

interface AnswerService {
    fun getAll() : List<Answer>
    fun getOne(id : Long) : Answer
    fun delete(id : Long)
    fun insert(answer : Answer) : Answer
    fun listByName(name : String) : List<Answer>
    fun listByQuestionId(questionId : Long) : List<Answer>
}