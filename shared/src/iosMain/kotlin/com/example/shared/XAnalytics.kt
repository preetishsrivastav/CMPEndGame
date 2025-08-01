package com.example.shared

object XAnalytics : IXAnalytics {
    override fun logEvent(
        eventName: String,
        params: Map<String, Any>?
    ) {
        firebaseIosCallback?.logEvent(eventName, params.toString())
    }

    private fun Map<String, Any>?.toString(): String {
        if (this == null) return ""

        val sb = StringBuilder()
        this.forEach {
            sb.append("${it.key}:${it.value},")
        }
        return sb.toString()
    }


    interface FirebaseIosCallback {
        fun logEvent(eventId: String, params: String)


    }

    private var firebaseIosCallback: FirebaseIosCallback? = null

    @Suppress("unused")
    fun firebaseCallback(callback: FirebaseIosCallback) {
        firebaseIosCallback = callback
    }
}