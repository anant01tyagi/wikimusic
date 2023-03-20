package com.example.musicwiki.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.api.RetroInstance
import com.example.musicwiki.api.RetroService
import com.example.musicwiki.models.TopTagsResponse
import com.example.musicwiki.models.albumInfoModelResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class albumScreenViewModel : ViewModel() {

    var albumScreenLiveData: MutableLiveData<albumInfoModelResponse> = MutableLiveData()

    fun getalbumScreenObserver() : MutableLiveData<albumInfoModelResponse> {
        return albumScreenLiveData

    }

    fun getAlbumInfo(artist : String, album : String){
        viewModelScope.launch(Dispatchers.IO){
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getAlbumInfo("de4c30f1af6eec62731cf8682373f5db", artist, album, "json")
            albumScreenLiveData.postValue(response)


        }
    }

}