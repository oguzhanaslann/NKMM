package com.example.nkmm.android

import android.app.Application
import com.example.nkmm.android.di.viewModelModule
import com.example.nkmm.di.appModule
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                appModule + viewModelModule
            )
        }
    }
}