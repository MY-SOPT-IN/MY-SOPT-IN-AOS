package com.example.soptin.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseDeleteRoutineDto (
    @SerialName("data")
    val data: Int,
    @SerialName("message")
    val message: String,
    @SerialName("code")
    val code: Int
    )