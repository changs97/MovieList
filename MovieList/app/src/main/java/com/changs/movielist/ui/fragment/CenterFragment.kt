package com.changs.movielist.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.changs.movielist.R
import com.changs.movielist.config.BaseFragment
import com.changs.movielist.databinding.FragmentCenterBinding
import com.changs.movielist.ui.activity.SplashActivity
import com.changs.movielist.ui.adapter.RecyclerViewAdapter


class CenterFragment :  BaseFragment<FragmentCenterBinding>(FragmentCenterBinding::bind, R.layout.fragment_center) {
    private lateinit var adapter : RecyclerViewAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        centerRecyclerSetUp()
    }
    private fun centerRecyclerSetUp() {
        val titleSortedFilmsList = SplashActivity.filmsList.sortedByDescending{ it.title }.reversed()
        val titleSortedFilmsArrayList = ArrayList(titleSortedFilmsList)
        adapter = RecyclerViewAdapter(titleSortedFilmsArrayList)
        binding.centerFragmentRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.centerFragmentRecyclerView.adapter = adapter
    }

}