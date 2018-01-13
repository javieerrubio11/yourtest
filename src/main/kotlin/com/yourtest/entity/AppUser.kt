package com.yourtest.entity

import javax.persistence.*

@Entity
@Table(name="app_user")
class AppUser(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var firstName: String = "",
        var lastName: String = "",
        var password: String = "",
        var username: String = ""
)