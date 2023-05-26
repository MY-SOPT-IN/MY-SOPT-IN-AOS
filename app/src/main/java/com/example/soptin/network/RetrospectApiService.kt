package com.example.soptin.network

import com.example.soptin.data.model.*
import com.example.soptin.data.model.ResponseCollectRetrospectDto
import com.example.soptin.data.model.ResponseOneRetrospectDto
import com.example.soptin.data.model.RetrospectDto
import retrofit2.Response
import retrofit2.http.*

interface RetrospectApiService {

    @GET("/retro/all?")
    suspend fun getRetrospect(@Query("month") month:Int): Response<ResponseCollectRetrospectDto>

    @GET("/retro?")
    suspend fun getOneRetrospect(@Query("date") date: String): Response<ResponseOneRetrospectDto>

    @PUT("/retro/{retroId}")
    suspend fun putRetrospect(
        @Path("retroId") retrospectId:Int,
        @Body body : RetrospectDto
        ): Response<ResponseOneRetrospectDto>

    @POST("/retro")
    suspend fun postRetrospect(
        @Body body: RequestPostRetrospectDto
    ): Response<ResponsePostRetrospectDto>

}