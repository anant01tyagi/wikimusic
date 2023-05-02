package com.example.musicwiki.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.R
import com.example.musicwiki.adapter.RecyclerViewAdapter
import com.example.musicwiki.models.TopTagsResponse
import com.example.musicwiki.viewModel.MainActivityViewModel


class RecyclerListFragment : Fragment() {
    private lateinit var recyclerAdapter: RecyclerViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recycler_list, container, false)

        initViewModel(view)
        initViewModel()
        return view
    }

    private fun initViewModel(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)



        recyclerView.layoutManager = LinearLayoutManager(activity)
//        val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
//        recyclerView.addItemDecoration(decoration)
        recyclerAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerAdapter


    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)


        viewModel.makeApiCall()
        viewModel.getRecyclerListObserver()
            .observe(viewLifecycleOwner, Observer<TopTagsResponse> {
                recyclerAdapter.setUpdatedItems(it.topTags.tagName)

            })

    }

    companion object {

        @JvmStatic
        fun newInstance() =
            RecyclerListFragment()
    }
}