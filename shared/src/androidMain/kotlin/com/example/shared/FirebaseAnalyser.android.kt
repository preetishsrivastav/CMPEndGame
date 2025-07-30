package com.example.shared

actual fun getXAnalytics(): IXAnalytics {
    return XAnalytics(context = null)
}