package com.example.musicwiki.models

import com.google.gson.annotations.SerializedName

data class topAlbumsModelResponse (
    @SerializedName("albums")
    val albums : albums

    )

data class albums(
    @SerializedName("album")
    val album : ArrayList<album>
)

data class album(
    @SerializedName("name")
    val albumName : String,
    @SerializedName("artist")
    val albumArtist : artist,
    @SerializedName("image")
    val albumImage : ArrayList<albumImage>
)

data class artist(
    @SerializedName("name")
    val artistName : String
)

data class albumImage(
    @SerializedName("#text")
    val imageUrl : String,
    @SerializedName("size")
    val imageSize: String
)