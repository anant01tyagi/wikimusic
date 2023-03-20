package com.example.musicwiki.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.api.RetroInstance
import com.example.musicwiki.api.RetroService
import com.example.musicwiki.models.topAlbumsModelResponse
import com.example.musicwiki.models.topArtistsModelResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class artistsFragmentViewModel : ViewModel() {

    var topArtistsLiveData : MutableLiveData<topArtistsModelResponse> = MutableLiveData()

    fun getTopArtistsObserver(): MutableLiveData<topArtistsModelResponse>{
        return topArtistsLiveData
    }

    fun getTopArtists(tagName : String){
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getTopArtists(tagName, "de4c30f1af6eec62731cf8682373f5db", "json")
            topArtistsLiveData.postValue(response)


        }
    }

}