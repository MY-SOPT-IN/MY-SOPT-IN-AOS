package com.example.soptin.data.repoimpl

import com.example.soptin.data.datasource.RetrospectDataSource
import com.example.soptin.data.model.ResponseCollectRetrospectDto
import com.example.soptin.data.model.ResponseCollectRetrospectDto2
import com.example.soptin.data.model.RetrospectDto
import retrofit2.Response

class RetrospectRepoImpl (
    private val retrospectDataSource: RetrospectDataSource
) {

    suspend fun getRetrospect(month:Int):Response<ResponseCollectRetrospectDto> =
        retrospectDataSource.getRetrospect(month)

    suspend fun putRetrospect(
        retrospectId: Int,
        retrospectDto: RetrospectDto
    ): Response<ResponseCollectRetrospectDto2> =
        retrospectDataSource.putRetrospect(retrospectId,retrospectDto)
}