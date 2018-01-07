package com.yourtest.controller

import com.yourtest.entity.Quiz
import com.yourtest.entity.QuizDto
import com.yourtest.service.IQuizService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/quiz")
class QuizController {
    @Autowired
    lateinit var quizService: IQuizService

    @GetMapping(value = "/all")
    fun getAll() = quizService.getAll()

    @GetMapping(value = "/get/{id}")
    fun get(@PathVariable id: Long) : Quiz {
        return quizService.getOne(id)
    }

    @PostMapping(value = "/insert")
    fun insert(@RequestBody quizDto : QuizDto) : List<Quiz> {
        quizService.insert(Quiz(quizDto))
        return quizService.getAll()
    }
}