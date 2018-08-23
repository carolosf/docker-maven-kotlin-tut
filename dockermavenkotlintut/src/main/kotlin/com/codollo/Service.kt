package com.codollo

class Service(val dbUser: String) {
    fun handle() {
        println(dbUser)
    }
}