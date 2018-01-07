package com.yourtest.service

import com.yourtest.dao.IQuizDAO
import com.yourtest.entity.Quiz
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class QuizService : IQuizService {
    @Autowired
    lateinit var quizDao : IQuizDAO

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