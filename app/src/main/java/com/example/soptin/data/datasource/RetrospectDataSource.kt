package com.example.soptin.data.datasource

import com.example.soptin.data.model.ResponseCollectRetrospectDto
import com.example.soptin.data.model.ResponseCollectRetrospectDto2
import com.example.soptin.data.model.RetrospectDto
import com.example.soptin.domain.RetrospectRepo
import com.example.soptin.network.RetrospectApiService
import retrofit2.Response
import retrofit2.http.Field

class RetrospectDataSource(private val apiService: RetrospectApiService) : RetrospectRepo {
    override suspend fun getRetrospect(month: Int): Response<ResponseCollectRetrospectDto> =
        apiService.getRetrospect(month)

    override suspend fun getOneRetrospect(date: String): Response<ResponseCollectRetrospectDto2> =
        apiService.getOneRetrospect(date)


    override suspend fun putRetrospect(
        retrospectId: Int,
        retrospectDto: RetrospectDto
    ): Response<ResponseCollectRetrospectDto2> =
        apiService.putRetrospect(retrospectId, retrospectDto)
}