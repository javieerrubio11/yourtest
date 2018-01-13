package com.yourtest.entity

import javax.persistence.*

@Entity
@Table(name="app_user")
class User(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var firstName: String = "",
        var lastName: String = "",
        var password: String = "",
        var username: String = "",

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "user_role",
                joinColumns = arrayOf(JoinColumn(name = "user_id", referencedColumnName = "id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "role_id", referencedColumnName = "id"))
        )
        var roles : List<Role> = emptyList()
)