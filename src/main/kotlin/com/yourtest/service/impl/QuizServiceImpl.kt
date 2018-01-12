package com.yourtest.service.impl

import com.yourtest.dao.QuizRepository
import com.yourtest.entity.Quiz
import com.yourtest.service.QuizService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class QuizServiceImpl : QuizService {
    @Autowired
    lateinit var quizDao : QuizRepository

    override fun getAll(): List<Quiz> {
        return quizDao.findAll()
    }

    override fun getOne(id: Long): Quiz {
        return quizDao.getOne(id)
    }

    override fun insert(quiz: Quiz): Quiz {
        try {
            return quizDao.save(quiz)
        } catch (e : Exception) {
            e.printStackTrace()
            throw Exception(e.localizedMessage)
        }
    }
}