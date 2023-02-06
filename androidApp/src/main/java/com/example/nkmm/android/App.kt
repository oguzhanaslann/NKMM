package com.example.nkmm.android

import android.app.Application
import com.example.nkmm.android.di.androidAppModule
import com.example.nkmm.android.di.androidModules
import com.example.nkmm.android.di.viewModelModule
import com.example.nkmm.di.sharedDepModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(androidModules)
            androidLogger()
            androidContext(this@App)
        }
    }
}