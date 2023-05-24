package com.example.soptin.data.datasource

import com.example.soptin.data.model.ResponseRoutineDto
import com.example.soptin.domain.RoutineRepo
import com.example.soptin.network.RoutineApiService
import retrofit2.Response

class RoutineDataSource(private val apiService: RoutineApiService):RoutineRepo {
    override suspend fun getRoutine(targetDate: String): Response<ResponseRoutineDto> =
        apiService.getRoutine(targetDate)
}