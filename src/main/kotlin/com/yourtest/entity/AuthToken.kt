package com.yourtest.entity

class AuthToken {

    var token: String? = null
    var user: User? = null

    constructor() {

    }

    constructor(token: String, user: User) {
        this.token = token
        this.user = user
    }

}