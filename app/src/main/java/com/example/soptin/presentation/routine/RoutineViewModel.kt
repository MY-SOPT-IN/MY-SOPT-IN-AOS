package com.example.soptin.presentation.routine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soptin.data.model.RoutineDto
import com.example.soptin.data.repoimpl.RoutineRepoImpl
import kotlinx.coroutines.launch

class RoutineViewModel (
    private val routineRepoImpl: RoutineRepoImpl
) : ViewModel(){
    private val _routineDto = MutableLiveData<List<RoutineDto>?>()
    val routineDto: LiveData<List<RoutineDto>?>
        get() = _routineDto
    fun getRoutine(targetDate:String) = viewModelScope.launch {
        val response = routineRepoImpl.getRoutine(targetDate)
        if(response.isSuccessful){
            _routineDto.value= response.body()?.data
        }
    }
    fun deleteRoutine(routineId:Int) =viewModelScope.launch {
        val response = routineRepoImpl.deleteRoutine(routineId)
        if(response.isSuccessful){

        }
    }


}