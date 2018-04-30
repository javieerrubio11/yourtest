package com.yourtest.service.impl

import com.yourtest.dao.AnswerRepository
import com.yourtest.entity.Answer
import com.yourtest.service.AnswerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class AnswerServiceImpl : AnswerService {
    @Autowired
    lateinit var answerRepository: AnswerRepository

    override fun getAll(): List<Answer> {
        return answerRepository.findAll()
    }

    override fun getOne(id: Long): Answer {
        return answerRepository.getOne(id)
    }

    override fun delete(id: Long) {
        answerRepository.delete(id)
    }

    override fun insert(answer: Answer): Answer {
        try {
            return answerRepository.save(answer)
        } catch (e : Exception) {
            e.printStackTrace()
            throw Exception(e.localizedMessage)
        }
    }

    override fun listByName(name : String): List<Answer> {
        return answerRepository.findByName(name)
    }

    override fun listByQuestionId(questionId : Long) : List<Answer> {
        return answerRepository.findByQuestion_Id(questionId)
    }
}