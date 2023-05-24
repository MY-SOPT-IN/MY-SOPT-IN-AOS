package com.example.soptin.data.datasource

import com.example.soptin.data.model.ResponseCollectRetrospectDto
import com.example.soptin.domain.RetrospectRepo
import com.example.soptin.network.RetrospectApiService
import retrofit2.Response

class RetrospectDataSource(private val apiService: RetrospectApiService) : RetrospectRepo {
    override suspend fun getRetrospect(month: Int): Response<ResponseCollectRetrospectDto> =
        apiService.getRetrospect(month)
}