package com.yourtest.entity

import javax.persistence.*

@Entity
@Table(name="user_role")
class UserRole (
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id")
        var userId: Long = 0,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "role_id")
        var roleId: Long = 0
)