package com.yourtest.entity

import javax.persistence.*

@Entity
@Table(name="exam")
class Exam (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "owner_id")
        var owner: User? = null,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "quiz_id")
        var quiz: Quiz? = null,

        var correct: Long = 0,
        var fail: Long = 0,
        var blank: Long = 0
    ) {
    constructor(examDTO: ExamDto) : this() {
        this.id = examDTO.id
        this.owner = User(examDTO.owner)
        this.quiz = Quiz(examDTO.quiz)
        this.correct = examDTO.correct
        this.fail = examDTO.fail
        this.blank = examDTO.blank
    }
}

class ExamDto(
        var id: Long = 0,
        var owner: Long = 0,
        var quiz: Long = 0,
        var correct: Long = 0,
        var fail: Long = 0,
        var blank: Long = 0
)