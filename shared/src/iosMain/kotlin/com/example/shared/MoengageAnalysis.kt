package com.example.shared

object MoengageAnalysis: MoenegageService {


    override fun trackEvent(
        eventName: String,
        attributes: Map<String, Any>?
    ) {
        moengageIosCallback?.trackEvent(eventName, attributes.toString())
    }

    private fun Map<String, Any>?.toString(): String {
        if (this == null) return ""

        val sb = StringBuilder()
        this.forEach {
            sb.append("${it.key}:${it.value},")
        }
        return sb.toString()
    }


    interface MoenegageIosCallback {
        fun trackEvent(eventId: String, params: String)
    }

    private var moengageIosCallback: MoenegageIosCallback? = null

    @Suppress("unused")
    fun moenegageCallback(callback: MoenegageIosCallback) {
        moengageIosCallback = callback
    }




}