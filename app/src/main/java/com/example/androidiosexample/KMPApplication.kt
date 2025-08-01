package com.example.androidiosexample

import android.app.Application
import com.example.shared.KoinInitializer
import com.moengage.core.LogLevel
import com.moengage.core.MoEngage
import com.moengage.core.config.FcmConfig
import com.moengage.core.config.LogConfig

class KMPApplication:Application() {

    override fun onCreate() {
        super.onCreate()

        KoinInitializer(
            context = applicationContext
        ).init()

        val moEngage = MoEngage.Builder(this, "9DJ33DP2UAZWTWBB7ZJFFH68")
            .configureLogs(LogConfig(LogLevel.VERBOSE, true))
            .configureFcm(FcmConfig(true)) // To enable push notifications
            .build()
        MoEngage.initialiseInstance(moEngage)

    }

}