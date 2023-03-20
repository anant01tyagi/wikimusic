package com.example.musicwiki.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.R
import com.example.musicwiki.adapter.artistsRVadapter
import com.example.musicwiki.models.staticVariables
import com.example.musicwiki.models.topArtistsModelResponse
import com.example.musicwiki.viewModel.artistsFragmentViewModel

class artistsFragment : Fragment() {

    private lateinit var artistsRVadapter: artistsRVadapter


    val tagName = staticVariables.tagName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_artists, container, false)
        initViewModel(view)
        initViewModel()
        return view
    }

    private fun initViewModel(view: View) {
        val artistsRecyclerView = view.findViewById<RecyclerView>(R.id.artistsRecyclerView)
        artistsRecyclerView.layoutManager = LinearLayoutManager(activity)
        artistsRVadapter = artistsRVadapter()
        artistsRecyclerView.adapter = artistsRVadapter


    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(artistsFragmentViewModel::class.java)
        viewModel.getTopArtistsObserver()
            .observe(viewLifecycleOwner, Observer<topArtistsModelResponse> {
                artistsRVadapter.setUpdatedItems(it.topArtists.artist)
            }
            )

        viewModel.getTopArtists(tagName)


    }




}