package com.yourtest

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class YourtestApplication

fun main(args: Array<String>) {
    SpringApplication.run(YourtestApplication::class.java, *args)
}