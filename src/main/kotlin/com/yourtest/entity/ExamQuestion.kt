package com.yourtest.entity

import javax.persistence.*

@Entity
@Table(name="examQuestion")
class ExamQuestion (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "exam_id")
        var exam: Exam? = null,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "quiz_id")
        var quiz: Quiz? = null,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "answer_id")
        var answer: Answer? = null
    ) {
    constructor(examQuestionDTO: ExamQuestionDto) : this() {
        this.id = examQuestionDTO.id
        this.exam = Exam(examQuestionDTO.exam)
        this.quiz = Quiz(examQuestionDTO.quiz)
        this.answer = Answer(examQuestionDTO.answer)
    }
}

class ExamQuestionDto(
        var id: Long = 0,
        var exam: Long = 0,
        var quiz: Long = 0,
        var answer: Long = 0
)