package com.yourtest.entity

import javax.persistence.*

@Entity
@Table(name="quiz")
class Quiz (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var name: String = "",

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "owner_id")
        var owner: User? = null
) {
    constructor(quizDTO: QuizDto) : this() {
        this.id = quizDTO.id
        this.name = quizDTO.name
        this.owner = User(quizDTO.owner)
    }
}

class QuizDto(
        var id: Long = 0,
        var name: String = "",
        var owner: Long = 0
)