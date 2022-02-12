package com.changs.movielist.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.changs.movielist.R
import com.changs.movielist.config.BaseFragment
import com.changs.movielist.data.model.FilmsModelItem
import com.changs.movielist.databinding.FragmentRightBinding
import com.changs.movielist.ui.activity.SplashActivity
import com.changs.movielist.ui.adapter.RecyclerViewAdapter
import java.util.ArrayList

class RightFragment  :  BaseFragment<FragmentRightBinding>(FragmentRightBinding::bind, R.layout.fragment_right) {
    private lateinit var adapter : RecyclerViewAdapter
    private lateinit var FavoritesFilmsArrayList : ArrayList<FilmsModelItem>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        leftRecyclerSetUp()

    }

    private fun leftRecyclerSetUp() {
        FavoritesFilmsArrayList = SplashActivity.filmsList
        val updatedList = updateList(FavoritesFilmsArrayList)
        adapter = RecyclerViewAdapter(updatedList)
        binding.rightFragmentRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.rightFragmentRecyclerView.adapter = adapter
    }

    private fun updateList(Films: ArrayList<FilmsModelItem>) : ArrayList<FilmsModelItem> {
        val updatedList : ArrayList<FilmsModelItem> = arrayListOf()
        if(Films.isNotEmpty()){
            for(data in FavoritesFilmsArrayList){
                if(data.checked2) updatedList.add(data)
            }
        }
        return updatedList
    }


}