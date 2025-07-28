package com.example.shared

sealed class ApiResponse<out T> {
    data object Loading : ApiResponse<Nothing>()
    data class Success<out T>(val data: T?) : ApiResponse<T>()
    data class Error(val message: String?, val errorBody: String? = null) : ApiResponse<Nothing>()
}