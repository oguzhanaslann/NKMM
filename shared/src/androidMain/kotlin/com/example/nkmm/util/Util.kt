package com.example.nkmm.util

actual fun randomUUID(): String {
    return java.util.UUID.randomUUID().toString()
}