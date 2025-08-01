package com.example.shared

interface MoenegageService {
    fun trackEvent(eventName: String, attributes: Map<String, Any>? = emptyMap())
}