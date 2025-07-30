package com.example.shared.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shared.data.LoginRepo
import com.example.shared.data.LoginRequest
import com.example.shared.data.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val loginRepo: LoginRepo): ViewModel() {

    private val _createUserResponse: MutableStateFlow<LoginResponse?> = MutableStateFlow(null)
    val createUserResponse = _createUserResponse.asStateFlow()

    fun createUser(loginRequest: LoginRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            loginRepo.createUser(loginRequest).collect { response ->
                when (response) {
                    is ApiResponse.Loading -> {
                        // Handle loading state
                    }
                    is ApiResponse.Success -> {
                        _createUserResponse.value = response.data
                    }
                    is ApiResponse.Error -> {
                        // Handle error state
                    }
                }
            }

        }
    }

}