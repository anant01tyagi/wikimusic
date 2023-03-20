package com.example.musicwiki.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.api.RetroInstance
import com.example.musicwiki.api.RetroService
import com.example.musicwiki.models.TaginfoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.musicwiki.adapter.RecyclerViewAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

public class GenreActivityViewModel : ViewModel() {
    var TagInfoLiveData :MutableLiveData<TaginfoResponse> = MutableLiveData()



    fun getTagInfoObserver(): MutableLiveData<TaginfoResponse>{
        return TagInfoLiveData
    }

    fun getTagInfo(tagname:String){
        viewModelScope.launch (Dispatchers.IO){
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getTagInfo(tagname, "de4c30f1af6eec62731cf8682373f5db", "json")
            TagInfoLiveData.postValue(response)

        }

    }





}