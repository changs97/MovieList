package com.changs.movielist.ui

import android.os.Bundle
import android.view.View
import com.changs.movielist.R
import com.changs.movielist.config.BaseFragment
import com.changs.movielist.databinding.FragmentRightBinding


class RightFragment :  BaseFragment<FragmentRightBinding>(FragmentRightBinding::bind, R.layout.fragment_right) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}