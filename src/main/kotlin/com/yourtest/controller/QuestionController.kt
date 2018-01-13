package com.yourtest.controller

import com.yourtest.entity.Question
import com.yourtest.entity.QuestionDto
import com.yourtest.service.QuestionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/question")
class QuestionController {
    @Autowired
    lateinit var questionService: QuestionService

    @GetMapping(value = "/all")
    fun getAll() = questionService.getAll()

    @GetMapping(value = "/get/{id}")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    fun get(@PathVariable id: Long) : Question {
        return questionService.getOne(id)
    }

    @PostMapping(value = "/insert")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    fun insert(@RequestBody questionDto: QuestionDto) : List<Question> {
        questionService.insert(Question(questionDto))
        return questionService.getAll()
    }

    @GetMapping(value = "/find/{nombre}")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    fun getByNombre(@PathVariable nombre: String) : List<Question> {
        return questionService.listByNombre(nombre)
    }
}