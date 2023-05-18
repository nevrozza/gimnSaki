package ktor

import AuthRepository
import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import di.Inject
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

internal val ktorModule = DI.Module("ktorModule") {
    bind<HttpClient>() with singleton {
        HttpClient(HttpEngineFactory().createEngine()) {

            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }

            install(DefaultRequest)

            install(ContentNegotiation) {
                json(Json {
                        isLenient = true
                        ignoreUnknownKeys = true
                        prettyPrint = true
                })
            }

            install(HttpTimeout) {
                connectTimeoutMillis = 15000
                requestTimeoutMillis = 30000
            }

            defaultRequest {
                val authRepository: AuthRepository = Inject.instance()
                header("Content-Type", "application/json; charset=UTF-8")
                when(authRepository.fetchDiary()) {
                    "eljur" -> url{
                        protocol = URLProtocol.HTTPS
                        host = "http://eljur.ru/api"
                        parameters.append("vendor", authRepository.fetchVendor())
                        parameters.append("devkey", authRepository.fetchDevKey())
                        parameters.append("out_format", "json")
                    }
                }
            }
        }
    }


}