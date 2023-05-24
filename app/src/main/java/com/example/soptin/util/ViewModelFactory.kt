package com.example.soptin.util

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.soptin.data.datasource.RoutineDataSource
import com.example.soptin.data.repoimpl.RoutineRepoImpl
import com.example.soptin.network.ServicePool
import com.example.soptin.presentation.home.RoutineViewModel


class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(RoutineViewModel::class.java) -> {
                val repository = RoutineRepoImpl(RoutineDataSource(ServicePool.routineApiService))
                RoutineViewModel(repository) as T
            }
            else -> {
                throw IllegalArgumentException("Failed to create ViewModel : ${modelClass.name}")
            }
        }
    }
}