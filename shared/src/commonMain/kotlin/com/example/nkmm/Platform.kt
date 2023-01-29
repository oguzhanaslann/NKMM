package com.example.nkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform