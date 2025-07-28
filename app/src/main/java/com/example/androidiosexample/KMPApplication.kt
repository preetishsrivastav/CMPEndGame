package com.example.androidiosexample

import android.app.Application
import com.example.shared.KoinInitializer

class KMPApplication:Application() {

    override fun onCreate() {
        super.onCreate()

        KoinInitializer(
            context = applicationContext
        ).init()

    }

}