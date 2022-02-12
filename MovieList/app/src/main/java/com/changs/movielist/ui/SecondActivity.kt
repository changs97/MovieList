package com.changs.movielist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.changs.movielist.R
import com.changs.movielist.config.BaseActivity
import com.changs.movielist.data.FilmsModelItem
import com.changs.movielist.databinding.ActivityMainBinding
import com.changs.movielist.databinding.ActivitySecondBinding

class SecondActivity : BaseActivity<ActivitySecondBinding>(ActivitySecondBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data = intent.getSerializableExtra("SecondActivity") as? FilmsModelItem

        if (data != null) {
            Glide.with(this)
                .load(data.image)
                .into(binding.secondImage)
            binding.secondTitle.text = data.title
            binding.secondScore.text = data.rt_score
            binding.secondScenario.text = data.producer
            binding.secondReleaseDate.text = data.release_date
            binding.secondRunningTime.text = data.running_time
            binding.secondDescription.text = data.description
            binding.secondDirectorName.text = data.director
        }
    }
}