package com.example.soptin.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RoutineDto(
    @SerialName("routineAt")
    val routineAt: String,
    @SerialName("routineId")
    val routineId: Int,
    @SerialName("routineName")
    val routineName: String
)