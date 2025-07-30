package com.example.shared.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.shared.data.LoginRequest
import com.example.shared.presentation.MainViewModel
import org.koin.compose.koinInject

@Composable
fun LoginForm(
    modifier: Modifier,
    onLoginBtnClick: () -> Unit
) {
    val mainViewModel : MainViewModel = koinInject<MainViewModel>()

    val createUserResponse by mainViewModel.createUserResponse.collectAsState()

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
    var loggedIn by remember { mutableStateOf(false) }

    LaunchedEffect(
        key1 = createUserResponse,
    ) {
        if (createUserResponse != null) {
            loggedIn = true
        }
    }

    if (loggedIn) {
        Text("Welcome, $username!", modifier = Modifier.fillMaxWidth())
    } else {
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Login", style = MaterialTheme.typography.headlineMedium)
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = modifier.fillMaxWidth(0.8f)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = modifier.fillMaxWidth(0.8f),
                visualTransformation = PasswordVisualTransformation()
            )
            if (error != null) {
                Text(error!!, color = MaterialTheme.colorScheme.error)
            }
            Button(onClick = {
                error = null
                if (username.isBlank() || password.isBlank()) {
                    error = "Please enter both username and password."
                } else {
                    mainViewModel.createUser(
                        LoginRequest(
                            username = username,
                            password = password
                        )
                    )
                }

                onLoginBtnClick()
            }, modifier = modifier.fillMaxWidth(0.8f)) {
                Text("Login")
            }
        }
    }
}