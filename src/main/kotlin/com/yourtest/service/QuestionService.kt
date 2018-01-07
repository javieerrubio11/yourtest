package com.yourtest.service

import com.yourtest.dao.IQuestionDAO
import com.yourtest.entity.Question
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class QuestionService : IQuestionService {
    @Autowired
    lateinit var questionDao: IQuestionDAO

    override fun getAll(): List<Question> {
        return questionDao.findAll()
    }

    override fun getOne(id: Long): Question {
        return questionDao.getOne(id)
    }

    override fun insert(question: Question): Question {
        try {
            return questionDao.save(question)
        } catch (e : Exception) {
            e.printStackTrace()
            throw Exception(e.localizedMessage)
        }
    }

    override fun listByNombre(nombre : String): List<Question> {
        return questionDao.findByNombre(nombre)
    }
}