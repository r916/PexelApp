package com.example.pexelapp.view.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pexelapp.R
import com.example.pexelapp.adapter.SearchAdapter
import com.example.pexelapp.util.Resource
import com.example.pexelapp.view.MainActivity
import com.example.pexelapp.viewmodel.PexelViewModel
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment(R.layout.fragment_search) {

    lateinit var viewModel: PexelViewModel
    lateinit var searchAdapter: SearchAdapter

    val TAG = "SearchFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()

        viewModel.searchPexels.observe(viewLifecycleOwner, Observer { response ->
            when(response) {
                is Resource.Success -> {
                    response.data?.let {searchResponse ->
                        searchAdapter.differ.submitList(searchResponse.list)
                    }
                }
                is Resource.Error -> {
                    response.message?.let {message ->
                        Log.e(TAG, "Error: $message")
                    }
                }
            }
        })
    }

    private fun setupRecyclerView() {
        searchAdapter = SearchAdapter()
        photo_grid_rv.apply {
            adapter = searchAdapter
            layoutManager = GridLayoutManager(activity, 2)
        }
    }
}