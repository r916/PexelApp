package com.example.pexelapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pexelapp.model.PexelResponse
import com.example.pexelapp.repository.Repository
import com.example.pexelapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class PexelViewModel(
    val searchRepository: Repository
) : ViewModel() {

    val searchPexels: MutableLiveData<Resource<PexelResponse>> = MutableLiveData()

    init {
        getPhotos("red", 1, 15)
    }

    private fun getPhotos(query: String, page: Int, perPage: Int) = viewModelScope.launch {
        searchPexels.postValue(Resource.Loading())
        val response = searchRepository.getPhotos(query, page, perPage)
        searchPexels.postValue(handleSearchPexelResponse(response))
    }

    private fun handleSearchPexelResponse(response: Response<PexelResponse>) : Resource<PexelResponse> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}