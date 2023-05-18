package ktor

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import models.Token

class KtorAuthRemoteDataSource(
    private val httpClient: HttpClient
) {
    suspend fun performElJurLogin(request: KtorElJurLoginRequest): Token {
        return httpClient.post {
            url {
                path("auth")
                setBody(request)
            }
        }.body()
    }
}