package com.example.soptin.network

import com.example.soptin.data.model.ResponseCollectRetrospectDto
import com.example.soptin.data.model.ResponseCollectRetrospectDto2
import com.example.soptin.data.model.ResponseRoutineDto
import com.example.soptin.data.model.RetrospectDto
import retrofit2.Response
import retrofit2.http.*

interface RetrospectApiService {

    @GET("/retro/all?")
    suspend fun getRetrospect(@Query("month") month:Int): Response<ResponseCollectRetrospectDto>

    @GET("/retro?")
    suspend fun getOneRetrospect(@Query("date") date: String): Response<ResponseCollectRetrospectDto2>

    @PUT("/retro/{retroId}")
    suspend fun putRetrospect(
        @Path("retroId") retrospectId:Int,
        @Body body :RetrospectDto
        ): Response<ResponseCollectRetrospectDto2>

}