package com.example.musicwiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.adapter.albumScreenGenreRVadapter
import com.example.musicwiki.models.staticVariables
import com.example.musicwiki.viewModel.albumScreenViewModel
import com.squareup.picasso.Picasso

class albumScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_screen)

        val albumNameForapi = staticVariables.albumName
        val albumArtistForapi = staticVariables.albumArtistName

        val albumImage = findViewById<ImageView>(R.id.albumImage)
        val albumName = findViewById<TextView>(R.id.albumName)
        val albumArtist = findViewById<TextView>(R.id.artistName)
        val albumDesciption = findViewById<TextView>(R.id.Description)

        val albumScreenGenreRVadapter : albumScreenGenreRVadapter = albumScreenGenreRVadapter()

        val albumGenreRecyclerView = findViewById<RecyclerView>(R.id.genreRecyclerView)

        albumGenreRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        albumGenreRecyclerView.adapter = albumScreenGenreRVadapter


        val viewModel = ViewModelProvider(this).get(albumScreenViewModel::class.java)

        viewModel.getAlbumInfo(albumArtistForapi, albumNameForapi)
        viewModel.albumScreenLiveData.observe(this, Observer {
            albumName.text = it.album.albumName
            albumArtist.text = it.album.artistName
            albumDesciption.text = it.album.wiki.summary
            albumScreenGenreRVadapter.setUpdatedItems(it.album.tags.tagInfo)

            val albumImageurl = it.album.albumCoverImage.get(2).url

            Picasso.get()
                .load(albumImageurl)
                .into(albumImage)

        })






    }
}