package com.example.musicwiki.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.api.RetroInstance
import com.example.musicwiki.api.RetroService
import com.example.musicwiki.models.albumInfoModelResponse
import com.example.musicwiki.models.artistInfoModelResponse
import com.example.musicwiki.models.artistTopAlbumsResponse
import com.example.musicwiki.models.artistTopTracksResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class artistScreenViewModel : ViewModel() {

    var artistScreenLiveData: MutableLiveData<artistInfoModelResponse> = MutableLiveData()
    var artistAlbumsLiveData: MutableLiveData<artistTopAlbumsResponse> = MutableLiveData()
    var artistTracksLiveData: MutableLiveData<artistTopTracksResponse> = MutableLiveData()


    fun getArtistScreenObserver() : MutableLiveData<artistInfoModelResponse> {
        return artistScreenLiveData

    }

    fun getArtistALbumsObserver() : MutableLiveData<artistTopAlbumsResponse> {
        return artistAlbumsLiveData

    }fun getArtistTracksObserver() : MutableLiveData<artistTopTracksResponse> {
        return artistTracksLiveData

    }

    fun getArtistInfo(artist : String){
        viewModelScope.launch(Dispatchers.IO){
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getArtistInfo(artist, "de4c30f1af6eec62731cf8682373f5db", "json")
            artistScreenLiveData.postValue(response)


        }
    }

    fun getArtistTopAlbums(artist : String){
        viewModelScope.launch(Dispatchers.IO){
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.artistGetTopAlbums(artist, "de4c30f1af6eec62731cf8682373f5db", "json")
            artistAlbumsLiveData.postValue(response)


        }
    }

    fun getArtistTopTracks(artist : String){
        viewModelScope.launch(Dispatchers.IO){
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.artistGetTopTracks(artist, "de4c30f1af6eec62731cf8682373f5db", "json")
            artistTracksLiveData.postValue(response)


        }
    }

}