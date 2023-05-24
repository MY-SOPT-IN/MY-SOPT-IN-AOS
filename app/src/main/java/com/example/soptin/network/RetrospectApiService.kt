package com.example.soptin.network

import com.example.soptin.data.model.ResponseCollectRetrospectDto
import com.example.soptin.data.model.ResponseRoutineDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrospectApiService {

    @GET("/retro/all?")
    suspend fun getRetrospect(@Query("month") month:Int): Response<ResponseCollectRetrospectDto>

}