package com.example.shared

import kotlinx.coroutines.flow.Flow

interface LoginRepo {
    suspend fun createUser(loginRequest: LoginRequest): Flow<ApiResponse<LoginResponse>>
}