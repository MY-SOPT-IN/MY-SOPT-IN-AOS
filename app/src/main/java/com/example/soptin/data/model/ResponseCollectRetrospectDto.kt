package com.example.soptin.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseCollectRetrospectDto(
    @SerialName("code")
    val code: Int,
    @SerialName("data")
    val `data`: List<RetrospectDto>?,
    @SerialName("message")
    val message: String
)

@Serializable
data class ResponseCollectRetrospectDto2(
    @SerialName("code")
    val code: Int,
    @SerialName("data")
    val `data`: RetrospectDto?,
    @SerialName("message")
    val message: String
)