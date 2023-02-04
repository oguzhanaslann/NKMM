package com.example.nkmm.data.local.factory

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.nkmm.db.NkmmDb

actual class DriverFactory(
    private val context: Context
) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(NkmmDb.Schema, context, "NkmmDb.db")
    }
}