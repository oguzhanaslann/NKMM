package com.example.nkmm.util

import platform.Foundation.NSUUID

actual fun randomUUID(): String {
    return NSUUID().UUIDString()
}