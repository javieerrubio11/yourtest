package com.yourtest.entity

import javax.persistence.*

@Entity
@Table(name="question")
class Question (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var name: String = "",

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "owner_id")
        var owner: Users? = null,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "quiz_id")
        var quiz: Quiz? = null
) {
        constructor(questionDTO: QuestionDto) : this() {
                this.id = questionDTO.id
                this.name = questionDTO.name
                this.owner = Users(questionDTO.owner)
                this.quiz = Quiz(questionDTO.quiz)
        }
}

class QuestionDto(
        var id: Long = 0,
        var name: String = "",
        var owner: Long = 0,
        var quiz: Long = 0
)