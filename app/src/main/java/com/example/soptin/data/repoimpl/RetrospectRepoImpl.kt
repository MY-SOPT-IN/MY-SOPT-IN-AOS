package com.example.soptin.data.repoimpl

import com.example.soptin.data.datasource.RetrospectDataSource
import com.example.soptin.data.model.*
import retrofit2.Response

class RetrospectRepoImpl(
    private val retrospectDataSource: RetrospectDataSource
) {

    suspend fun getRetrospect(month: Int): Response<ResponseCollectRetrospectDto> =
        retrospectDataSource.getRetrospect(month)

    suspend fun getOneRetrospect(date: String): Response<ResponseOneRetrospectDto> =
        retrospectDataSource.getOneRetrospect(date)

    suspend fun putRetrospect(
        retrospectId: Int,
        retrospectDto: RetrospectDto
    ): Response<ResponseOneRetrospectDto> =
        retrospectDataSource.putRetrospect(retrospectId, retrospectDto)

    suspend fun postRetrospect(
        request: RequestPostRetrospectDto
    ): Response<ResponsePostRetrospectDto> = retrospectDataSource.postRetrospect(request)

}

// interface repo - repo impl <- (datasource - api - remotedatasource)
//view model repoimpl