package ktor

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class KtorElJurLoginRequest(
    @SerialName("login") val login: String,
    @SerialName("password") val password: String,
//    @SerialName("vendor") val vendor: String,
//    @SerialName("devkey") val devKey: String = "c4ca4238a0b923820dcc509a6f75849b",
//    @SerialName("out_format") val outFormat: String = "json"
)
