package com.example.soptin.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ResponseOneRetrospectDto(
  @SerialName("code")
  val code:Int,
  @SerialName("message")
  val message:String,
  @SerialName("data")
  val data: RetrospectDto?
)