package com.changs.movielist.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.changs.movielist.MyApplication
import com.changs.movielist.R
import com.changs.movielist.data.model.FilmsModelItem
import com.changs.movielist.data.viewmodel.FilmsViewModel
import com.changs.movielist.databinding.FragmentLeftBinding
import com.changs.movielist.ui.activity.SecondActivity
import com.changs.movielist.ui.adapter.RecyclerViewAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class LeftFragment :  Fragment() {

    private lateinit var binding: FragmentLeftBinding

    @Inject
    lateinit var model: FilmsViewModel

    private lateinit var leftAdapter : RecyclerViewAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_left, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model.getMovieByRank()
        initRecyclerView()
        initObservers()

    }

    private fun initRecyclerView() {
        leftAdapter = RecyclerViewAdapter(1)
        binding.leftFragmentRecyclerView.layoutManager = LinearLayoutManager(context)


        leftAdapter.setBookMarkClickListener(object : RecyclerViewAdapter.ItemClickListener {
            override fun onClick(view: View, movie: FilmsModelItem) {
                val isBookMarked =
                    view.findViewById<CheckBox>(R.id.item_favorite)
                CoroutineScope(Dispatchers.IO).launch {
                    if (!isBookMarked.isChecked) {
                        model.deleteBookmark(movie.id)
                    } else {
                        model.insertBookmark(movie)
                    }
                }
            }

            override fun setChecked(movie: FilmsModelItem): Boolean {
                return model.isBookMarked(movie.id)
            }
        })
        binding.leftFragmentRecyclerView.adapter = leftAdapter
    }

    private fun initObservers() {
        model.movie.observe(viewLifecycleOwner, Observer { it ->
            it?.let { leftAdapter.submitList(it)
            Log.d("성공",it.toString())}
        })
    }




}