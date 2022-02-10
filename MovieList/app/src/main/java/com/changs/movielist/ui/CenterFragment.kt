package com.changs.movielist.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.changs.movielist.R
import com.changs.movielist.config.BaseFragment
import com.changs.movielist.databinding.FragmentCenterBinding


class CenterFragment :  BaseFragment<FragmentCenterBinding>(FragmentCenterBinding::bind, R.layout.fragment_center) {
    private var adapter : RecyclerViewAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        centerRecyclerSetUp()
    }
    private fun centerRecyclerSetUp() {
        val titleSortedFilmsList = SplashActivity.filmsList.sortedByDescending{ it.title }
        adapter = RecyclerViewAdapter(titleSortedFilmsList, 2)
        binding.centerFragmentRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.centerFragmentRecyclerView.adapter = adapter
    }
}