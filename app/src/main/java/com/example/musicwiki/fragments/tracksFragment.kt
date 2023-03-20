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
import com.example.musicwiki.adapter.tracksRVadapter
import com.example.musicwiki.models.staticVariables
import com.example.musicwiki.models.topTracksModelResponse
import com.example.musicwiki.viewModel.tracksFragmentViewModel


class tracksFragment : Fragment() {

    private lateinit var tracksRVadapter: tracksRVadapter


    val tagName = staticVariables.tagName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tracks, container, false)
        initViewModel()
        initViewModel(view)

        return view
    }


    private fun initViewModel(view: View) {
        val tracksrecyclerView = view.findViewById<RecyclerView>(R.id.tracksRecyclerView)
        tracksrecyclerView.layoutManager = LinearLayoutManager(activity)
        tracksRVadapter = tracksRVadapter()
        tracksrecyclerView.adapter = tracksRVadapter


    }


    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(tracksFragmentViewModel::class.java)
        viewModel.getTopAlbumsObserver()
            .observe(viewLifecycleOwner, Observer<topTracksModelResponse> {
                tracksRVadapter.setUpdatedItems(it.topTracks.track)
            }
            )

        viewModel.getTopTracks(tagName)


    }

}