package com.example.nkmm.di

import app.cash.sqldelight.db.SqlDriver
import com.example.nkmm.data.local.factory.DriverFactory
import com.example.nkmm.db.NkmmDb
import org.koin.core.qualifier.named
import org.koin.dsl.module

val iosModule = module {
    single<NkmmDb>(named(NKMM_DB_DI_NAME)) {
        NkmmDb(getDriver())
    }
}

fun getDriver(): SqlDriver {
    return DriverFactory().createDriver()
}