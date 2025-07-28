package com.example.shared

import kotlinx.coroutines.flow.Flow

interface Api {
    suspend fun createUser(loginRequest: LoginRequest): Flow<ApiResponse<LoginResponse>>
}