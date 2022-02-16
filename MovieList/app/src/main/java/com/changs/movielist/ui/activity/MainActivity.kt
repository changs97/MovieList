package com.changs.movielist.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.changs.movielist.R
import com.changs.movielist.config.BaseActivity
import com.changs.movielist.data.viewmodel.FilmsViewModel
import com.changs.movielist.databinding.ActivityMainBinding
import com.changs.movielist.ui.adapter.ViewPagerAdapter


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // 페이저에 어댑터 연결
        binding.viewPager.adapter = ViewPagerAdapter(this)


        // 슬라이드하여 페이지가 변경되면 바텀네비게이션의 탭도 그 페이지로 활성화
        binding.viewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bottomNavigationView.menu.getItem(position).isChecked = true
                }
            }
        )

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu1 -> {
                    // ViewPager의 현재 item에 첫 번째 화면을 대입
                    binding.viewPager.currentItem = 0
                    return@setOnItemSelectedListener true
                }
                R.id.menu2 -> {
                    // ViewPager의 현재 item에 두 번째 화면을 대입
                    binding.viewPager.currentItem = 1
                    return@setOnItemSelectedListener true
                }
               /* R.id.menu3 -> {
                    // ViewPager의 현재 item에 세 번째 화면을 대입
                    binding.viewPager.currentItem = 2
                    return@setOnItemSelectedListener true
                }*/
                else -> {
                    return@setOnItemSelectedListener false
                }
            }
        }

    }





}