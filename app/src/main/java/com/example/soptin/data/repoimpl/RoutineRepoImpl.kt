package com.example.soptin.data.repoimpl

import com.example.soptin.data.datasource.RoutineDataSource
import com.example.soptin.data.model.ResponseDeleteRoutineDto
import com.example.soptin.data.model.ResponseRoutineDto
import retrofit2.Response

class RoutineRepoImpl(
    private val routineDataSource: RoutineDataSource
) {

    suspend fun getRoutine(targetDate: String): Response<ResponseRoutineDto> =
        routineDataSource.getRoutine(targetDate)

    suspend fun deleteRoutine(routineId: Int): Response<ResponseDeleteRoutineDto> =
        routineDataSource.deleteRoutine(routineId)
}