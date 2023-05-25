package com.example.soptin.domain

import com.example.soptin.data.model.*
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.Path

interface RetrospectRepo {
    suspend fun getRetrospect(month: Int): Response<ResponseCollectRetrospectDto>

    suspend fun getOneRetrospect(date: String): Response<ResponseOneRetrospectDto>

    suspend fun putRetrospect(
        retrospectId: Int,
        retrospectDto: RetrospectDto
    ): Response<ResponseOneRetrospectDto>

    suspend fun postRetrospect(
        request : RequestPostRetrospectDto
    ) : Response<ResponsePostRetrospectDto>

}