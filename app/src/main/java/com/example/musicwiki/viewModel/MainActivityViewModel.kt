package com.example.musicwiki.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.api.RetroInstance
import com.example.musicwiki.api.RetroService
import com.example.musicwiki.models.TopTagsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {
    var recyclerListLiveData: MutableLiveData<TopTagsResponse> = MutableLiveData()

    fun getRecyclerListObserver() : MutableLiveData<TopTagsResponse> {
        return recyclerListLiveData

    }

    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO){
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getApiData()
            recyclerListLiveData.postValue(response)


        }
    }
}