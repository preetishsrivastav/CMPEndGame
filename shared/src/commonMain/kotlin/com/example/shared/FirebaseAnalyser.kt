package com.example.shared

expect fun getXAnalytics(): IXAnalytics

interface IXAnalytics {
    fun logEvent(eventName: String, params: Map<String, Any>?)
}

