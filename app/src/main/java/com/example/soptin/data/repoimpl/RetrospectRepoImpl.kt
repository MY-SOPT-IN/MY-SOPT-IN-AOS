package com.example.soptin.data.repoimpl

import com.example.soptin.data.datasource.RetrospectDataSource
import com.example.soptin.data.model.ResponseCollectRetrospectDto
import retrofit2.Response

class RetrospectRepoImpl (
    private val retrospectDataSource: RetrospectDataSource
) {

    suspend fun getRetrospect(month:Int):Response<ResponseCollectRetrospectDto> =
        retrospectDataSource.getRetrospect(month)
}