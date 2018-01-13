package com.yourtest.entity

import javax.persistence.*

@Entity
@Table(name="app_role")
class Role(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var description: String = "",
        var roleName: String = ""
)