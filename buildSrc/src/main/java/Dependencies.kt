object Dependencies  {
    object Koin {
        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val test = "io.insert-koin:koin-test:${Versions.koin}"
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
        const val android_compose = "io.insert-koin:koin-androidx-compose:${Versions.koin_android_compose}"
    }

    val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"

    object SqlDelight {
        const val android_driver = "app.cash.sqldelight:android-driver:${Versions.sqlDelight}"
        const val native_driver = "app.cash.sqldelight:native-driver:${Versions.sqlDelight}"
        const val coroutines_extension = "app.cash.sqldelight:coroutines-extensions:${Versions.sqlDelight}"
    }
}

object Versions {
    const val koin = "3.3.2"
    const val koin_android = "3.3.2"
    const val koin_android_compose = "3.4.1"
    const val koin_ktor = "3.3.0"
    const val coroutines = "1.6.4"
    const val sqlDelight = "2.0.0-alpha05"
}