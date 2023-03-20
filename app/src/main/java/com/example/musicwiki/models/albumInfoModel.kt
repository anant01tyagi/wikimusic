package com.example.musicwiki.models

import com.google.gson.annotations.SerializedName

data class albumInfoModelResponse (
    @SerializedName("album")
    val album: albumInfo
)

data class albumInfo(
    @SerializedName("artist")
    val artistName : String,
    @SerializedName("tags")
    val tags : tag,
    @SerializedName("image")
    val albumCoverImage: ArrayList<Image>,
    @SerializedName("name")
    val albumName : String,
    @SerializedName("wiki")
    val wiki : wikiInfo

)

data class Image(
    @SerializedName("#text")
    val url : String
)

data class tag(
    @SerializedName("tag")
    val tagInfo : ArrayList<tagInfo>
)
data class tagInfo(
    @SerializedName("name")
    val tagName : String
)

data class wikiInfo(
    @SerializedName("summary")
    val summary : String
)