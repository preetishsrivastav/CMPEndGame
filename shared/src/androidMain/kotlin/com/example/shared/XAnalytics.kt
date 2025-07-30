package com.example.shared

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import org.koin.mp.KoinPlatform

class XAnalytics(private val context: Context?) : IXAnalytics {
    private val firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)

    override fun logEvent(eventName: String, params: Map<String, Any>?) {
        firebaseAnalytics.setUserProperty("app_version", "1.0")
        val bundle: Bundle? = params?.run {
            val bundle = Bundle()
            this.forEach { (t, u) ->
                when (u) {
                    is String -> bundle.putString(t, u)
                    is Int -> bundle.putInt(t, u)
                    is Long -> bundle.putLong(t, u)
                    is Float -> bundle.putFloat(t, u)
                    is Double -> bundle.putDouble(t, u)
                    else -> bundle.putString(t, u.toString())
                }
            }
            bundle
        }
        firebaseAnalytics.logEvent(eventName, bundle)
    }
}