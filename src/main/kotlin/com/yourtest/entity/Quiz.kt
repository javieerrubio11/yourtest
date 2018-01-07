package com.yourtest.entity

import java.lang.reflect.Constructor
import javax.persistence.*

@Entity
@Table(name="quiz")
class Quiz (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var nombre: String = "",

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "owner_id")
        var owner: Users? = null
) {
    constructor(quizDTO: QuizDto) : this() {
        this.id = quizDTO.id
        this.nombre = quizDTO.nombre
        this.owner = Users(quizDTO.owner)
    }
}

class QuizDto(
        var id: Long = 0,
        var nombre: String = "",
        var owner: Long = 0
)