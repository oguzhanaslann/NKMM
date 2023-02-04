package com.example.nkmm.data.local.factory

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.example.nkmm.db.NkmmDb

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(NkmmDb.Schema, "NkmmDb.db")
    }
}