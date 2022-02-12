package com.changs.movielist.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.changs.movielist.R
import com.changs.movielist.config.BaseFragment
import com.changs.movielist.databinding.FragmentLeftBinding
import com.changs.movielist.ui.activity.SplashActivity
import com.changs.movielist.ui.adapter.RecyclerViewAdapter
import java.util.ArrayList


class LeftFragment :  BaseFragment<FragmentLeftBinding>(FragmentLeftBinding::bind, R.layout.fragment_left) {
    private var adapter : RecyclerViewAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        leftRecyclerSetUp()

    }

    private fun leftRecyclerSetUp() {
        val scoreSortedFilmsList = SplashActivity.filmsList.sortedByDescending{ it.rt_score }
        val scoreSortedFilmsArrayList = ArrayList(scoreSortedFilmsList)

        adapter = RecyclerViewAdapter(scoreSortedFilmsArrayList)
        binding.leftFragmentRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.leftFragmentRecyclerView.adapter = adapter
    }
}