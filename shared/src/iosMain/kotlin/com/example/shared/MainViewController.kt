package com.example.shared

import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import com.example.shared.presentation.LoginForm

fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer().init()
    }
){
    LoginForm(
        modifier = Modifier,
        onLoginBtnClick = {
            XAnalytics.logEvent("login", mapOf("username" to "emilys", "password" to "emilyspass"))
            MoengageAnalysis.trackEvent(eventName = "LOGIN_SUCCESS", attributes = mapOf("username" to "Yulu", "password" to "emilyspass"))
        }
    )
}