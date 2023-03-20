package com.example.musicwiki.models

import com.google.gson.annotations.SerializedName

data class TaginfoResponse(
    @SerializedName("tag")
    val genre: genre
)

data class genre(
    @SerializedName("wiki")
    val wiki : wiki,
    @SerializedName("name")
    val name: String)

data class wiki(
    @SerializedName("summary")
    val summary : String
)