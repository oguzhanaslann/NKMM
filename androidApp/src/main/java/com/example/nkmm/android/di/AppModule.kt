package com.example.nkmm.android.di

import app.cash.sqldelight.db.SqlDriver
import com.example.nkmm.data.local.factory.DriverFactory
import com.example.nkmm.db.NkmmDb
import com.example.nkmm.di.NKMM_DB_DI_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val androidAppModule = module {
    single<NkmmDb>(named(NKMM_DB_DI_NAME)) {
        NkmmDb(getDriver(androidContext()))
    }
}

fun getDriver(context: android.content.Context): SqlDriver {
    return DriverFactory(context).createDriver()
}