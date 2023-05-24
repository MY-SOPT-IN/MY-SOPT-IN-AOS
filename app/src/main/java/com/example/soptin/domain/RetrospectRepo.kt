package com.example.soptin.domain

import com.example.soptin.data.model.ResponseCollectRetrospectDto
import retrofit2.Response

interface RetrospectRepo {
    suspend fun getRetrospect(month:Int): Response<ResponseCollectRetrospectDto>
}