package com.changs.movielist.ui

import android.os.Bundle
import android.view.View
import com.changs.movielist.R
import com.changs.movielist.config.BaseFragment
import com.changs.movielist.databinding.FragmentLeftBinding


class LeftFragment :  BaseFragment<FragmentLeftBinding>(FragmentLeftBinding::bind, R.layout.fragment_left) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}