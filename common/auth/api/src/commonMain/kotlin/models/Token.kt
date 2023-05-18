package models

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Token(
    @SerialName("token") val token: String
)
