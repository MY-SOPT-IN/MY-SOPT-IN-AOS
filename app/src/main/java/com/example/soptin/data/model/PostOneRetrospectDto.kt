package com.example.soptin.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestPostRetrospectDto(
    @SerialName("isPublic")
    val isPublic:Boolean,
    @SerialName("descRoutine")
    val descRoutine:String,
    @SerialName("descBest")
    val descBest:String,
    @SerialName("descSelf")
    val descSelf:String,
    @SerialName("writtenDate")
    val writtenDate:String
)

@Serializable
data class ResponsePostRetrospectDto(
    @SerialName("code")
    val code:Int,
    @SerialName("message")
    val message:String,
    @SerialName("data")
    val data:RetrospectDto?
)