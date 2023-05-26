package com.example.soptin.domain

import com.example.soptin.data.model.RequestPostRetrospectDto
import com.example.soptin.data.model.ResponseCollectRetrospectDto
import com.example.soptin.data.model.ResponseOneRetrospectDto
import com.example.soptin.data.model.RetrospectDto
import com.example.soptin.data.model.ResponsePostRetrospectDto
import retrofit2.Response

interface RetrospectRepo {
    suspend fun getRetrospect(month: Int): Response<ResponseCollectRetrospectDto>

    suspend fun getOneRetrospect(date: String): Response<ResponseOneRetrospectDto>

    suspend fun putRetrospect(
        retrospectId: Int,
        retrospectDto: RetrospectDto
    ): Response<ResponseOneRetrospectDto>

    suspend fun postRetrospect(
        request: RequestPostRetrospectDto
    ): Response<ResponsePostRetrospectDto>

}