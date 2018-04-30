package com.yourtest.entity

import javax.persistence.*

@Entity
@Table(name="answer")
class Answer (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var name: String = "",
        var correct: Boolean = false,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "question_id")
        var question: Question? = null
) {
    constructor(answerDTO: AnswerDto) : this() {
        this.id = answerDTO.id
        this.name = answerDTO.name
        this.correct = answerDTO.correct
        this.question = Question(answerDTO.question)
    }
}

class AnswerDto(
        var id: Long = 0,
        var name: String = "",
        var correct: Boolean = false,
        var question: Long = 0
)