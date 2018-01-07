package com.yourtest.dao

import com.yourtest.entity.Quiz
import org.springframework.data.jpa.repository.JpaRepository

interface IQuizDAO : JpaRepository<Quiz, Long>