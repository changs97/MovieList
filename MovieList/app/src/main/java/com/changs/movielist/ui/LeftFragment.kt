package com.changs.movielist.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.changs.movielist.R
import com.changs.movielist.config.BaseFragment
import com.changs.movielist.databinding.FragmentLeftBinding


class LeftFragment :  BaseFragment<FragmentLeftBinding>(FragmentLeftBinding::bind, R.layout.fragment_left) {
    private var adapter : RecyclerViewAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        leftRecyclerSetUp()

    }

    private fun leftRecyclerSetUp() {
        val scoreSortedFilmsList = SplashActivity.filmsList.sortedByDescending{ it.rt_score }
        adapter = RecyclerViewAdapter(scoreSortedFilmsList)
        binding.leftFragmentRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.leftFragmentRecyclerView.adapter = adapter
    }
}