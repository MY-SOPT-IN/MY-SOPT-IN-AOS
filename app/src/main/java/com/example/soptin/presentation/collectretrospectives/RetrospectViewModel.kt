package com.example.soptin.presentation.collectretrospectives

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soptin.data.model.RequestPostRetrospectDto
import com.example.soptin.data.model.ResponseCollectRetrospectDto
import com.example.soptin.data.model.RetrospectDto
import com.example.soptin.data.repoimpl.RetrospectRepoImpl
import com.example.soptin.util.Event
import kotlinx.coroutines.launch
import retrofit2.Response

class RetrospectViewModel(
    private val retrospectRepoImpl: RetrospectRepoImpl
) : ViewModel() {

    private val _retrospectDto = MutableLiveData<List<RetrospectDto>?>()
    val retrospectDto: LiveData<List<RetrospectDto>?>
        get() = _retrospectDto

    private val _oneRetrospectDto = MutableLiveData<RetrospectDto?>()
    val oneRetrospectDto: LiveData<RetrospectDto?> get() = _oneRetrospectDto

    private val _retrospectId = MutableLiveData<Event<Int>>()
    val retrospectId: LiveData<Event<Int>>
        get() = _retrospectId

    private val _code = MutableLiveData<Int>()
    val code: LiveData<Int> get() = _code

    private val _getRetroId = MutableLiveData<Int?>()
    val getRetroId: LiveData<Int?> get() = _getRetroId

    fun getRetrospect(month: Int) = viewModelScope.launch {
        val response = retrospectRepoImpl.getRetrospect(month)
        if (response.isSuccessful) {
            _retrospectDto.value = response.body()?.data
        }
    }

    fun getOneRetrospect(date: String) = viewModelScope.launch {
        val response = retrospectRepoImpl.getOneRetrospect(date)
        if (response.isSuccessful) {
            Log.d("test", response.body().toString())
            _getRetroId.value= response.body()?.data?.retrospectId
            _code.value = response.body()?.code
            _oneRetrospectDto.value = response.body()?.data
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

    fun showUpdate(retrospectId: Int) {
        _retrospectId.value = Event(retrospectId)
    }

}