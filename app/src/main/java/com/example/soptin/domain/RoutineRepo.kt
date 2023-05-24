package com.example.soptin.domain

import com.example.soptin.data.ResponseRoutineDto
import retrofit2.Response

interface RoutineRepo {
    suspend fun getRoutine(targetDate:String):Response<ResponseRoutineDto>
}