object Dependencies  {
    object Koin {
        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val test = "io.insert-koin:koin-test:${Versions.koin}"
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
        const val android_compose = "io.insert-koin:koin-androidx-compose:${Versions.koin_android_compose}"
    }
}

object Versions {
    const val koin = "3.3.2"
    const val koin_android = "3.3.2"
    const val koin_android_compose = "3.4.1"
    const val koin_ktor = "3.3.0"
}