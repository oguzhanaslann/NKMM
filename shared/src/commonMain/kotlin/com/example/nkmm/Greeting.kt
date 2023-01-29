package com.example.nkmm

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    fun nkmmGreet(): String {
        return "Hello, NKMM!"
    }
}