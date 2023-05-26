package com.example.soptin.domain

import com.example.soptin.data.model.ResponseDeleteRoutineDto
import com.example.soptin.data.model.ResponseRoutineDto
import retrofit2.Response

interface RoutineRepo {
    suspend fun getRoutine(targetDate: String): Response<ResponseRoutineDto>

    suspend fun deleteRoutine(routineId: Int): Response<ResponseDeleteRoutineDto>
}