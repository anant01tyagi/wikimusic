package com.example.musicwiki.api


import com.example.musicwiki.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("?method=tag.getTopTags&api_key=de4c30f1af6eec62731cf8682373f5db&format=json")
    suspend fun getApiData(): TopTagsResponse

    @GET("?method=tag.getinfo")
    suspend fun getTagInfo(@Query("tag") tagName: String, @Query("api_key") apiKey: String, @Query("format") format: String) : TaginfoResponse

    @GET("?method=tag.gettopalbums")
    suspend fun getTopAlbums(@Query("tag") tagName: String, @Query("api_key") apiKey: String, @Query("format") format: String) : topAlbumsModelResponse

    @GET("?method=tag.gettopartists")
    suspend fun getTopArtists(@Query("tag") tagName: String, @Query("api_key") apiKey: String, @Query("format") format: String) : topArtistsModelResponse

    @GET("?method=tag.gettoptracks")
    suspend fun getTopTracks(@Query("tag") tagName: String, @Query("api_key") apiKey: String, @Query("format") format: String) : topTracksModelResponse

    @GET("?method=album.getinfo")
    suspend fun getAlbumInfo( @Query("api_key") apiKey: String,@Query("artist") artist: String,@Query("album") album: String, @Query("format") format: String) : albumInfoModelResponse

    @GET("?method=artist.getinfo")
    suspend fun getArtistInfo( @Query("artist") artist: String,@Query("api_key") apikey: String, @Query("format") format: String) : artistInfoModelResponse

    @GET("?method=artist.gettopalbums")
    suspend fun artistGetTopAlbums( @Query("artist") artist: String,@Query("api_key") apikey: String, @Query("format") format: String) : artistTopAlbumsResponse

    @GET("?method=artist.gettoptracks")
    suspend fun artistGetTopTracks ( @Query("artist") artist: String,@Query("api_key") apikey: String, @Query("format") format: String) : artistTopTracksResponse








}

