package com.example.soptin.domain

import com.example.soptin.data.model.ResponseCollectRetrospectDto
import com.example.soptin.data.model.ResponseCollectRetrospectDto2
import com.example.soptin.data.model.RetrospectDto
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.Path

interface RetrospectRepo {
    suspend fun getRetrospect(month: Int): Response<ResponseCollectRetrospectDto>

    suspend fun putRetrospect(
        retrospectId: Int,
        retrospectDto: RetrospectDto
    ): Response<ResponseCollectRetrospectDto2>
}