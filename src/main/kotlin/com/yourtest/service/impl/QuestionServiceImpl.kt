package com.yourtest.service.impl

import com.yourtest.dao.QuestionRepository
import com.yourtest.entity.Question
import com.yourtest.service.QuestionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class QuestionServiceImpl : QuestionService {
    @Autowired
    lateinit var questionRepository: QuestionRepository

    override fun getAll(): List<Question> {
        return questionRepository.findAll()
    }

    override fun getOne(id: Long): Question {
        return questionRepository.getOne(id)
    }

    override fun delete(id: Long) {
        questionRepository.delete(id)
    }

    override fun insert(question: Question): Question {
        try {
            return questionRepository.save(question)
        } catch (e : Exception) {
            e.printStackTrace()
            throw Exception(e.localizedMessage)
        }
    }

    override fun listByName(name : String): List<Question> {
        return questionRepository.findByName(name)
    }

    override fun listByQuizId(quizId : Long) : List<Question> {
        return questionRepository.findByQuiz_Id(quizId)
    }
}