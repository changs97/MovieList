package com.changs.movielist.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.changs.movielist.R
import com.changs.movielist.config.BaseFragment
import com.changs.movielist.databinding.FragmentRightBinding


class RightFragment :  BaseFragment<FragmentRightBinding>(FragmentRightBinding::bind, R.layout.fragment_right) {
    private var adapter : RecyclerViewAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        
    }
    private fun rightRecyclerSetUp() {
        adapter = RecyclerViewAdapter(SplashActivity.filmsList, 3)
        binding.rightFragmentRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.rightFragmentRecyclerView.adapter = adapter
    }
}