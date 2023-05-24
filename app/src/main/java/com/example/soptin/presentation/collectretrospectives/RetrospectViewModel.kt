package com.example.soptin.presentation.collectretrospectives

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soptin.data.model.RetrospectDto
import com.example.soptin.data.repoimpl.RetrospectRepoImpl
import kotlinx.coroutines.launch

class RetrospectViewModel (
    private val retrospectRepoImpl: RetrospectRepoImpl
) : ViewModel(){
    private val _retrospectDto = MutableLiveData<List<RetrospectDto>?>()
    val retrospectDto: LiveData<List<RetrospectDto>?>
        get() = _retrospectDto

    fun getRetrospect(month:Int) = viewModelScope.launch {
        val response = retrospectRepoImpl.getRetrospect(month)
        if(response.isSuccessful){
           _retrospectDto.value = response.body()?.data
        }
    }


}