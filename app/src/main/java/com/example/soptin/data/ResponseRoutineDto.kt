package com.example.soptin.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseRoutineDto(
    @SerialName("data")
    val `data`: List<RoutineDto>?,
    @SerialName("message")
    val message: String,
    @SerialName("code")
    val code: Int
)