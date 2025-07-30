package com.example.shared.domain

import com.example.shared.data.Api
import com.example.shared.data.LoginRepo
import com.example.shared.data.LoginRequest
import com.example.shared.data.LoginResponse
import com.example.shared.presentation.ApiResponse
import kotlinx.coroutines.flow.Flow

class LoginRepoImplementation(private val api: Api): LoginRepo {
    override suspend fun createUser(loginRequest: LoginRequest): Flow<ApiResponse<LoginResponse>> {
        return api.createUser(loginRequest)
    }
}