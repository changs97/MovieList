package com.changs.movielist.ui.fragment



import android.content.Context
import android.content.Intent
import android.graphics.Movie

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
import com.changs.movielist.databinding.FragmentRightBinding
import com.changs.movielist.ui.activity.SecondActivity
import com.changs.movielist.ui.adapter.RecyclerViewAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RightFragment  : Fragment() {

    @Inject
    lateinit var viewModel: FilmsViewModel
    private lateinit var binding: FragmentRightBinding
    private lateinit var rightAdapter: RecyclerViewAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_right, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        initObservers()
    }

    private fun initRecyclerView() {
        rightAdapter = RecyclerViewAdapter(::itemOnClick)
        binding.rightFragmentRecyclerView.layoutManager = LinearLayoutManager(context)
        rightAdapter.setBookMarkClickListener(object : RecyclerViewAdapter.ItemClickListener {
            override fun onClick(view: View, movie: FilmsModelItem) {
                val isBookMarked =
                    view.findViewById<CheckBox>(R.id.item_favorite)
                CoroutineScope(Dispatchers.IO).launch {
                    if (!isBookMarked.isChecked) {
                        viewModel.deleteBookmark(movie.id)
                    } else {
                        viewModel.insertBookmark(movie)
                    }
                }
            }

            override fun setChecked(movie: FilmsModelItem): Boolean {
                return viewModel.isBookMarked(movie.id)
            }
        })

        binding.rightFragmentRecyclerView.adapter = rightAdapter
    }

    private fun initObservers() {
        viewModel.getBookmark().observe(viewLifecycleOwner, Observer {
            it?.let { rightAdapter.submitList(it)
            Log.d("북마크",it.toString())}

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