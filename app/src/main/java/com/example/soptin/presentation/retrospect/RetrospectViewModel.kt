package com.example.soptin.presentation.retrospect

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soptin.data.model.RequestPostRetrospectDto
import com.example.soptin.data.model.ResponseOneRetrospectDto
import com.example.soptin.data.model.RetrospectDto
import com.example.soptin.data.repoimpl.RetrospectRepoImpl
import com.example.soptin.util.Event
import kotlinx.coroutines.launch

class RetrospectViewModel(
    private val retrospectRepoImpl: RetrospectRepoImpl
) : ViewModel() {

    private val _retrospectDto = MutableLiveData<List<RetrospectDto>?>()
    val retrospectDto: LiveData<List<RetrospectDto>?>
        get() = _retrospectDto


    private val _retrospectId = MutableLiveData<Event<RetrospectDto>>()
    val retrospectId: LiveData<Event<RetrospectDto>>
        get() = _retrospectId


    private val _getRetroDto = MutableLiveData<ResponseOneRetrospectDto>()
    val getRetroDto: LiveData<ResponseOneRetrospectDto> get() = _getRetroDto

    fun getRetrospect(month: Int) = viewModelScope.launch {
        val response = retrospectRepoImpl.getRetrospect(month)
        if (response.isSuccessful) {
            _retrospectDto.value = response.body()?.data
        }
    }

    fun getOneRetrospect(date: String) = viewModelScope.launch {
        val response = retrospectRepoImpl.getOneRetrospect(date)
        if (response.isSuccessful) {
            _getRetroDto.value=response.body()
        }
    }



    fun putRetrospect(retrospectId: Int,retrospectDto: RetrospectDto) = viewModelScope.launch {
        val response = retrospectRepoImpl.putRetrospect(retrospectId,retrospectDto)
        if (response.isSuccessful) {
            Log.d("test", response.body().toString())
        }
    }

    fun postRetrospect(request: RequestPostRetrospectDto) = viewModelScope.launch {
        val response = retrospectRepoImpl.postRetrospect(request)
        if (response.isSuccessful) {
            Log.d("test", response.body().toString())
        }
    }

    fun showUpdate(retrospectId: RetrospectDto) {
        _retrospectId.value = Event(retrospectId)
    }

}