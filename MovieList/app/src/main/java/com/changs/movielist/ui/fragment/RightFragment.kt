package com.changs.movielist.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.changs.movielist.R
import com.changs.movielist.config.BaseFragment
import com.changs.movielist.data.viewmodel.FilmsViewModel
import com.changs.movielist.data.model.FilmsModelItem
import com.changs.movielist.databinding.FragmentRightBinding
import com.changs.movielist.ui.activity.SplashActivity
import com.changs.movielist.ui.adapter.RecyclerViewAdapter

import java.util.ArrayList
/*
class RightFragment  :  BaseFragment<FragmentRightBinding>(FragmentRightBinding::bind, R.layout.fragment_right) {
    private lateinit var RightAdapter : RecyclerViewAdapter
    private lateinit var FavoritesFilmsArrayList : ArrayList<FilmsModelItem>
    private val model: FilmsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FavoritesFilmsArrayList = SplashActivity.filmsList
        var updatedList = updateList(FavoritesFilmsArrayList)
        model.setDatas(updatedList)
        RightAdapter = RecyclerViewAdapter(3)
        RightAdapter.setData(updatedList)
        binding.rightFragmentRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.rightFragmentRecyclerView.adapter = RightAdapter

        model.getFilms().observe(this, Observer<ArrayList<FilmsModelItem>>{ films ->

            updatedList = updateList(FavoritesFilmsArrayList)
            RightAdapter.setData(updatedList)
            Log.d("테스트","변화1")
        })

    }



    private fun updateList(Films: ArrayList<FilmsModelItem>) : ArrayList<FilmsModelItem> {
        val updatedList : ArrayList<FilmsModelItem> = arrayListOf()
        if(Films.isNotEmpty()){
            for(data in FavoritesFilmsArrayList){
                if(data.checked) updatedList.add(data)
            }
        }
        return updatedList
    }


}*/