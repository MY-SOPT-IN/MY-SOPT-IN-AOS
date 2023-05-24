package com.example.soptin.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RetrospectDto(
    @SerialName("descBest")
    val descBest: String,
    @SerialName("descRoutine")
    val descRoutine: String,
    @SerialName("descSelf")
    val descSelf: String,
    @SerialName("public")
    val `public`: Boolean?,
    @SerialName("isPublic")
    val `isPublic`: Boolean,
    @SerialName("retrospectId")
    val retrospectId: Int?,
    @SerialName("writtenDate")
    val writtenDate: String
)