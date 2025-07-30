package com.example.shared.data

import com.example.shared.presentation.ApiResponse
import kotlinx.coroutines.flow.Flow

interface LoginRepo {
    suspend fun createUser(loginRequest: LoginRequest): Flow<ApiResponse<LoginResponse>>
}