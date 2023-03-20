package com.example.musicwiki.models

import com.google.gson.annotations.SerializedName


//artist.getinfo
data class artistInfoModelResponse (
    @SerializedName("artist")
    val artistInformation : artistInformation
        )

data class artistInformation(
    @SerializedName("name")
    val name : String,
    @SerializedName("image")
    val artistImage : ArrayList<artistInfoImage>,
    @SerializedName("stats")
    val stats : stats,
    @SerializedName("tags")
    val artistInfoTags : artistInfoTags,
    @SerializedName("bio")
    val bio : bio
)

data class bio(
    @SerializedName("summary")
    val summary : String
)

data class artistInfoImage(
    @SerializedName("#text")
    val artistInfoImageUrl : String
)

data class artistInfoTags(
    @SerializedName("tag")
    val artistInfoTag : ArrayList<artistInfoTag>
)

data class artistInfoTag(
    @SerializedName("name")
    val name : String
    )


data class stats(
    @SerializedName("listeners")
    val followers : String,
    @SerializedName("playcount")
    val playCount : String
)



//gettopalbums
data class artistTopAlbumsResponse(
    @SerializedName("topalbums")
    val topAlbums : artistTopAlbums
)

data class artistTopAlbums(
    @SerializedName("album")
    val artistTopALbum: ArrayList<artistTopALbum>
)

data class artistTopALbum (
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val artistTopAlbumImage : ArrayList<artistTopAlbumImage>,
    @SerializedName("artist")
    val artistTopAlbumName : artistTopAlbumName
)

data class artistTopAlbumName(
    @SerializedName("name")
    val name : String
)

data class artistTopAlbumImage(
    @SerializedName("#text")
    val artistTopAlbumImageUrl : String
)


//gettoptracks
data class artistTopTracksResponse(
    @SerializedName("toptracks")
    val artistTopTracks : artistTopTracks
)

data class artistTopTracks(
    @SerializedName("track")
    val artstTopTrack : ArrayList<artistTopTrack>
)

data class artistTopTrack(
    @SerializedName("name")
    val artistTopTrackName : String,
    @SerializedName("image")
    val artistTopTrackImage : ArrayList<artistTopTrackImage>
)

data class artistTopTrackImage(
    @SerializedName("#text")
    val artistTopTrackImageUrl : String
)
