package com.example.shared

import org.koin.core.context.startKoin

actual class KoinInitializer {
    actual fun init() {
        startKoin {
            modules(listOf(appModule, viewModelModule, httpClientModule))
        }
    }
}