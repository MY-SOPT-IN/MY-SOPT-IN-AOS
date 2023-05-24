package com.example.soptin.data.repoimpl

import com.example.soptin.data.model.ResponseRoutineDto
import com.example.soptin.data.datasource.RoutineDataSource
import retrofit2.Response

class RoutineRepoImpl(
    private val routineDataSource: RoutineDataSource
) {

    suspend fun getRoutine(targetDate:String):Response<ResponseRoutineDto> =
        routineDataSource.getRoutine(targetDate)
}