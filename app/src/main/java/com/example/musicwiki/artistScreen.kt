package com.example.musicwiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.adapter.artistScreenAlbumRVadapter
import com.example.musicwiki.adapter.artistScreenGenreRVadapter
import com.example.musicwiki.adapter.artistScreenTrackRVadapter
import com.example.musicwiki.models.staticVariables
import com.example.musicwiki.viewModel.artistScreenViewModel
import com.squareup.picasso.Picasso

class artistScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_screen)

        val artist = staticVariables.artistArtistName


        val artistImage = findViewById<ImageView>(R.id.artistImage)
        val artistName = findViewById<TextView>(R.id.artistName)
        val playCountValue = findViewById<TextView>(R.id.playCountValue)
        val followersValue = findViewById<TextView>(R.id.followersValue)
        val artistDescription = findViewById<TextView>(R.id.artistDescription)




        val artistTopAlbumsRV = findViewById<RecyclerView>(R.id.artistTopAlbumsRV)
        val artistScreenAlbumRVadapter : artistScreenAlbumRVadapter = artistScreenAlbumRVadapter()
        artistTopAlbumsRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        artistTopAlbumsRV.adapter = artistScreenAlbumRVadapter


        val artistGenreRV = findViewById<RecyclerView>(R.id.artistGenreRV)
        val artistScreenGenreRVadapter : artistScreenGenreRVadapter = artistScreenGenreRVadapter()
        artistGenreRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        artistGenreRV.adapter = artistScreenGenreRVadapter



        val artistTopTracksRV = findViewById<RecyclerView>(R.id.artistTopTracksRV)
        val artistScreenTrackRVadapter : artistScreenTrackRVadapter = artistScreenTrackRVadapter()
        artistTopTracksRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        artistTopTracksRV.adapter = artistScreenTrackRVadapter




        val viewModel = ViewModelProvider(this).get(artistScreenViewModel::class.java)

        viewModel.getArtistInfo(artist)
        viewModel.artistScreenLiveData.observe(this, Observer {
            artistName.text = it.artistInformation.name
            playCountValue.text = it.artistInformation.stats.playCount
            followersValue.text = it.artistInformation.stats.followers
            artistDescription.text = it.artistInformation.bio.summary

            artistScreenGenreRVadapter.setUpdatedItems(it.artistInformation.artistInfoTags.artistInfoTag)


            val artistImageurl = it.artistInformation.artistImage.get(2).artistInfoImageUrl
            Picasso.get()
                .load(artistImageurl)
                .into(artistImage)

        })


        viewModel.getArtistTopAlbums(artist)
        viewModel.artistAlbumsLiveData.observe(this, Observer {
            artistScreenAlbumRVadapter.setUpdatedItems(it.topAlbums.artistTopALbum)
        })

        viewModel.getArtistTopTracks(artist)
        viewModel.artistTracksLiveData.observe(this, Observer {
            artistScreenTrackRVadapter.setUpdatedItems(it.artistTopTracks.artstTopTrack)
        })






    }
}