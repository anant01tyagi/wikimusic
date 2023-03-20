package com.example.musicwiki.viewModel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.api.RetroInstance
import com.example.musicwiki.api.RetroService
import com.example.musicwiki.genreActivity
import com.example.musicwiki.models.TaginfoResponse
import com.example.musicwiki.models.topAlbumsModelResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class albumsFragmentViewModel : ViewModel() {

    var topAlbumsLiveData : MutableLiveData<topAlbumsModelResponse> = MutableLiveData()



    fun getTopAlbumsObserver(): MutableLiveData<topAlbumsModelResponse>{
        return topAlbumsLiveData
    }

    fun getTopAlbums(tagName : String){
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getTopAlbums(tagName, "de4c30f1af6eec62731cf8682373f5db", "json")
            topAlbumsLiveData.postValue(response)


        }
    }

}