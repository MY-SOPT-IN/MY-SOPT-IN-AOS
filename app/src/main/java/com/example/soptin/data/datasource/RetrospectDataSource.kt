package com.example.soptin.data.datasource

import com.example.soptin.data.model.*
import com.example.soptin.domain.RetrospectRepo
import com.example.soptin.network.RetrospectApiService
import retrofit2.Response
import retrofit2.http.Field

class RetrospectDataSource(private val apiService: RetrospectApiService) : RetrospectRepo {
    override suspend fun getRetrospect(month: Int): Response<ResponseCollectRetrospectDto> =
        apiService.getRetrospect(month)

    override suspend fun getOneRetrospect(date: String): Response<ResponseOneRetrospectDto> =
        apiService.getOneRetrospect(date)


    override suspend fun putRetrospect(
        retrospectId: Int,
        retrospectDto: RetrospectDto
    ): Response<ResponseOneRetrospectDto> =
        apiService.putRetrospect(retrospectId, retrospectDto)

    override suspend fun postRetrospect(request: RequestPostRetrospectDto): Response<ResponsePostRetrospectDto> =
        apiService.postRetrospect(request)
}