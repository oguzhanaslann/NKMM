package com.example.nkmm.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(iosModules)
    }
}