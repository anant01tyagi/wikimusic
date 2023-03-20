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
import com.example.musicwiki.adapter.albumsRVadapter
import com.example.musicwiki.models.staticVariables
import com.example.musicwiki.models.topAlbumsModelResponse
import com.example.musicwiki.viewModel.albumsFragmentViewModel

class albumsFragment : Fragment() {

    private lateinit var albumsRVadapter: albumsRVadapter


    val tagName = staticVariables.tagName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_albums, container, false)
        initViewModel()
        initViewModel(view)
        return view
    }

    private fun initViewModel(view: View) {
        val albumsrecyclerView = view.findViewById<RecyclerView>(R.id.albumsRecyclerView)
        albumsrecyclerView.layoutManager = LinearLayoutManager(activity)
        albumsRVadapter = albumsRVadapter()
        albumsrecyclerView.adapter = albumsRVadapter


    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(albumsFragmentViewModel::class.java)
        viewModel.getTopAlbumsObserver()
            .observe(viewLifecycleOwner, Observer<topAlbumsModelResponse> {
                albumsRVadapter.setUpdatedItems(it.albums.album)
            }
            )

        viewModel.getTopAlbums(tagName)


    }


}