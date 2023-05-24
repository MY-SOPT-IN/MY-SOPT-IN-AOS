package com.example.soptin.network

import com.example.soptin.data.ResponseRoutineDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RoutineApiService {

    @GET("/routine/{targetDate}")
    suspend fun getRoutine(@Path("targetDate") targetDate:String): Response<ResponseRoutineDto>

}