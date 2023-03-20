package com.example.musicwiki.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object{
        val BaseUrl = "https://ws.audioscrobbler.com/2.0/"

        fun getRetroInstance():Retrofit{
            return Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}