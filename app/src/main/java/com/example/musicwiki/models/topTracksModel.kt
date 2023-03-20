package com.example.musicwiki.models

import com.google.gson.annotations.SerializedName

data class topTracksModelResponse (
    @SerializedName("tracks")
    val topTracks: tracks
)

data class tracks(
    @SerializedName("track")
    val track : ArrayList<track>
)

data class track(
    @SerializedName("name")
    val trackName : String,
    @SerializedName("artist")
    val trackArtist : trackArtist,
    @SerializedName("image")
    val trackImage : ArrayList<trackImage>
)

data class trackArtist(
    @SerializedName("name")
    val trackArtistName : String
)

data class trackImage(
    @SerializedName("#text")
    val trackImageUrl : String
)