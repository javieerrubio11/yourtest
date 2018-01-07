package com.yourtest.service

import com.yourtest.entity.Quiz

interface IQuizService {
    fun getAll() : List<Quiz>
    fun getOne(id : Long) : Quiz
    fun insert(quiz : Quiz) : Quiz
}