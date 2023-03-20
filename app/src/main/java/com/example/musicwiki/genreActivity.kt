package com.example.musicwiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.musicwiki.adapter.viewPagerAdapter
import com.example.musicwiki.fragments.albumsFragment
import com.example.musicwiki.fragments.artistsFragment
import com.example.musicwiki.fragments.tracksFragment
import com.example.musicwiki.models.staticVariables
import com.example.musicwiki.viewModel.GenreActivityViewModel
import com.google.android.material.tabs.TabLayout


class genreActivity : AppCompatActivity() {

    var tagFromButton = staticVariables.tagName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre)
        val genreName : TextView = findViewById(R.id.TagName)
        val genreDescription : TextView = findViewById(R.id.genreDescription)


        val viewModel = ViewModelProvider(this).get(GenreActivityViewModel::class.java)

        viewModel.getTagInfo(tagFromButton)
        viewModel.TagInfoLiveData.observe(this, Observer {
            genreDescription.setText(it.genre.wiki.summary)
            genreName.setText(tagFromButton.toString())


        })






        setUpTabs()
    }



    private fun setUpTabs() {

        val viewPager : ViewPager = findViewById(R.id.viewPager)
        val tabLayout : TabLayout = findViewById(R.id.tabs)

        val adapter = viewPagerAdapter(supportFragmentManager)
        adapter.addFragment(albumsFragment(), "Albums")
        adapter.addFragment(tracksFragment(), "Tracks")
        adapter.addFragment(artistsFragment(), "Artists")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

    }
}