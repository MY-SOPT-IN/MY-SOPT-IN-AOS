package com.example.soptin.presentation.collectretrospectives

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soptin.data.model.RetrospectDto
import com.example.soptin.data.repoimpl.RetrospectRepoImpl
import com.example.soptin.util.Event
import kotlinx.coroutines.launch

class RetrospectViewModel (
    private val retrospectRepoImpl: RetrospectRepoImpl
) : ViewModel(){

    private val _retrospectDto = MutableLiveData<List<RetrospectDto>?>()
    val retrospectDto: LiveData<List<RetrospectDto>?>
        get() = _retrospectDto

    private val _retrospectId = MutableLiveData<Event<Int>>()
    val retrospectId: LiveData<Event<Int>>
        get() = _retrospectId


    fun getRetrospect(month:Int) = viewModelScope.launch {
        val response = retrospectRepoImpl.getRetrospect(month)
        if(response.isSuccessful){
           _retrospectDto.value = response.body()?.data
        }
    }

    fun showUpdate(retrospectId:Int) {
       _retrospectId.value = Event(retrospectId)
    }

}