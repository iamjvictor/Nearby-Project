package com.rocketseat.nearby.core.network

import io.ktor.client.*
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object KtorHttpClient {
    private const val NETWORK_TIMEOUT = 25_000L

    val httpClientAndroid by lazy {
        HttpClient(Android) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    useAlternativeNames = true
                    ignoreUnknownKeys = true
                    explicitNulls = true
                    useArrayPolymorphism = true
                    encodeDefaults = false
                })
            }

            install(HttpTimeout) {
                requestTimeoutMillis = NETWORK_TIMEOUT
                connectTimeoutMillis = NETWORK_TIMEOUT
                socketTimeoutMillis = NETWORK_TIMEOUT
            }

            install(Logging) {
                level = LogLevel.ALL
            }
        }
    }
}
