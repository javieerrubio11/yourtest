package com.yourtest.controller

import com.yourtest.entity.Answer
import com.yourtest.entity.AnswerDto
import com.yourtest.entity.Question
import com.yourtest.service.AnswerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/answer")
@CrossOrigin("*")
class AnswerController {
    @Autowired
    lateinit var answerService: AnswerService

    @GetMapping(value = "/all")
    fun getAll() = answerService.getAll()

    @GetMapping(value = "/get/{id}")
    fun get(@PathVariable id: Long) : Answer {
        return answerService.getOne(id)
    }

    @DeleteMapping(value = "/{id}")
    fun delete(@PathVariable id: Long) : List<Answer> {
        var answer = answerService.getOne(id);
        var questionId: Long? = answer?.question?.id;
        try {
            answerService.delete(id)
            if(questionId != null)
                return answerService.listByQuestionId(questionId)
            else
                return emptyList();
        } catch (e : Exception) {
            e.printStackTrace()
            throw Exception(e.localizedMessage)
        }
    }

    @PostMapping(value = "/insert")
    fun insert(@RequestBody answerDto: AnswerDto) : List<Answer> {
        answerService.insert(Answer(answerDto))
        return answerService.getAll()
    }

    @GetMapping(value = "/findByQuestion/{questionId}")
    fun getByQuizId(@PathVariable questionId: Long) : List<Answer> {
        return answerService.listByQuestionId(questionId)
    }

    @GetMapping(value = "/find/{nombre}")
    fun getByNombre(@PathVariable nombre: String) : List<Answer> {
        return answerService.listByName(nombre)
    }
}