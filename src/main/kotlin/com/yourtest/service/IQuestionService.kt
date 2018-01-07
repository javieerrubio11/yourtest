package com.yourtest.service

import com.yourtest.entity.Question

interface IQuestionService {
    fun getAll() : List<Question>
    fun getOne(id : Long) : Question
    fun insert(question : Question) : Question
    fun listByNombre(nombre : String) : List<Question>
}