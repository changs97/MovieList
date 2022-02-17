package com.changs.movielist.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
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
import com.changs.movielist.databinding.FragmentCenterBinding
import com.changs.movielist.ui.activity.SecondActivity

import com.changs.movielist.ui.adapter.RecyclerViewAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class CenterFragment :  Fragment() {

    private lateinit var binding: FragmentCenterBinding

    @Inject
    lateinit var model: FilmsViewModel

    private lateinit var centerAdapter: RecyclerViewAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_center, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model.getMovieByRank()
        initRecyclerView()
        initObservers()

    }

    private fun initRecyclerView() {
        centerAdapter = RecyclerViewAdapter(::itemOnClick)
        binding.centerFragmentRecyclerView.layoutManager = LinearLayoutManager(context)


        centerAdapter.setBookMarkClickListener(object : RecyclerViewAdapter.ItemClickListener {
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

        binding.centerFragmentRecyclerView.adapter = centerAdapter
    }

    private fun initObservers() {
        model.movie.observe(viewLifecycleOwner, Observer { it ->
            it?.let { centerAdapter.submitList(it) }
        })
    }

    private fun itemOnClick(movie: FilmsModelItem) {
        startActivity(
            Intent(activity, SecondActivity::class.java)
                .putExtra("id", movie.id)
                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        )
    }


}