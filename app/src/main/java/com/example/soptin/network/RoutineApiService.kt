package com.example.soptin.network

import com.example.soptin.data.model.ResponseDeleteRoutineDto
import com.example.soptin.data.model.ResponseRoutineDto
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface RoutineApiService {

    @GET("/routine/{targetDate}")
    suspend fun getRoutine(@Path("targetDate") targetDate:String): Response<ResponseRoutineDto>

    @DELETE("/routine/{routineId}")
    suspend fun deleteRoutine(@Path("routineId") routineId:Int): Response<ResponseDeleteRoutineDto>
}