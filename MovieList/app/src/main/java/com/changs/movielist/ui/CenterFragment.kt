package com.changs.movielist.ui

import android.os.Bundle
import android.view.View
import com.changs.movielist.R
import com.changs.movielist.config.BaseFragment
import com.changs.movielist.databinding.FragmentCenterBinding


class CenterFragment :  BaseFragment<FragmentCenterBinding>(FragmentCenterBinding::bind, R.layout.fragment_center) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}