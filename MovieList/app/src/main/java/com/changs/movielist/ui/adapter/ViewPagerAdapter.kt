package com.changs.movielist.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.changs.movielist.ui.fragment.CenterFragment
import com.changs.movielist.ui.fragment.LeftFragment

class ViewPagerAdapter (fragment : FragmentActivity) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LeftFragment()
            else -> CenterFragment()
        }
    }
}