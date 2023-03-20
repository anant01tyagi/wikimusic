package com.example.musicwiki.models

import com.google.gson.annotations.SerializedName

data class topArtistsModelResponse (
        @SerializedName("topartists")
        val topArtists : topArtists
        )


data class topArtists(
        @SerializedName("artist")
        val artist : ArrayList<artistinfo>
)

data class artistinfo(
        @SerializedName("name")
        val name : String,
        @SerializedName("image")
        val image : ArrayList<artistImage>
)

data class artistImage(
        @SerializedName("#text")
        val artistImageurl : String
)