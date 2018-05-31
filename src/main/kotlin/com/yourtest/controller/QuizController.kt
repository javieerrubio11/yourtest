package com.yourtest.controller

import com.yourtest.entity.Quiz
import com.yourtest.entity.QuizDto
import com.yourtest.service.QuizService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/quiz")
@CrossOrigin("*")
class QuizController {
    @Autowired
    lateinit var quizService: QuizService

    @GetMapping(value = "/all")
    fun getAll() = quizService.getAll()

    @GetMapping(value = "/get/{id}")
    fun get(@PathVariable id: Long) : Quiz {
        return quizService.getOne(id)
    }

    @PostMapping(value = "/insert")
    fun insert(@RequestBody quizDto : QuizDto) : Quiz {
        return quizService.insert(Quiz(quizDto))
    }

    @DeleteMapping(value = "/{id}")
    fun delete(@PathVariable id: Long) : List<Quiz> {

        try {
            quizService.delete(id)
            return getAll()
        } catch (e : Exception) {
            e.printStackTrace()
            throw Exception(e.localizedMessage)
        }
    }
}