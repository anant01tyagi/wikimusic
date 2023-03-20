package com.example.musicwiki.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.api.RetroInstance
import com.example.musicwiki.api.RetroService
import com.example.musicwiki.models.topAlbumsModelResponse
import com.example.musicwiki.models.topTracksModelResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class tracksFragmentViewModel : ViewModel() {

    var topTracksLiveData : MutableLiveData<topTracksModelResponse> = MutableLiveData()



    fun getTopAlbumsObserver(): MutableLiveData<topTracksModelResponse> {
        return topTracksLiveData
    }

    fun getTopTracks(tagName : String){
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getTopTracks(tagName, "de4c30f1af6eec62731cf8682373f5db", "json")
            topTracksLiveData.postValue(response)


        }
    }

}