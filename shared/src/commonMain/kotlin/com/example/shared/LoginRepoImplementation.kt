package com.example.shared

import kotlinx.coroutines.flow.Flow

class LoginRepoImplementation(private val api: Api): LoginRepo{
    override suspend fun createUser(loginRequest: LoginRequest): Flow<ApiResponse<LoginResponse>> {
        return api.createUser(loginRequest)
    }
}