package com.example.shared

import co.touchlab.kermit.Logger
import com.example.shared.ApiEndpoints.LOGIN
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive

class ApiImplementation(private val client: HttpClient): Api {
    override suspend fun createUser(loginRequest: LoginRequest): Flow<ApiResponse<LoginResponse>> {
        return flow {
            try {
                Logger.i("Event-Logs"){ "${client.isActive}" }
                emit(ApiResponse.Loading)

                val response = client.post(LOGIN) {
                    setBody(loginRequest)
                }

                if (response.status.isSuccess()) {
                    val loginResponse = response.body<LoginResponse>()
                    emit(ApiResponse.Success(loginResponse))
                } else {
                    val errorBody = response.bodyAsText()
                    Logger.e("Event-Logs") { "API Error: ${response.status} - $errorBody" }
                    emit(ApiResponse.Error("Error: ${response.status.description}"))
                }
            } catch (e: RedirectResponseException) {
                Logger.e("Event-Logs"){ "RedirectResponseException: ${e.message}"}
                emit(ApiResponse.Error(e.response.status.description))
            } catch (e: ClientRequestException) {
                Logger.e("Event-Logs"){ "ClientRequestException: ${e.message}"}
                emit(ApiResponse.Error(e.response.status.description))
            } catch (e: ServerResponseException) {
                Logger.e("Event-Logs"){ "ServerResponseException: ${e.message}"}
                emit(ApiResponse.Error(e.response.status.description))
            } catch (e: Exception) {
                // This will catch low-level errors like "Connection reset" if they still occur
                Logger.e("Event-Logs"){ "Exception: ${e.message}"}
                emit(ApiResponse.Error(e.message ?: "An unknown error occurred"))
            }
        }    }
}