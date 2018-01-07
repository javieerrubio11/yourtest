package com.yourtest.entity

import javax.persistence.*

@Entity
@Table(name="users")
class Users(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var nombre: String = "",
        var apellidos: String = "",
        var email: String = ""
)