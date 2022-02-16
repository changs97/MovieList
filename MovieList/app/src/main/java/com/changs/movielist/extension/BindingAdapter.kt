package com.changs.movielist.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {

    @BindingAdapter("loadImage")
    @JvmStatic
    fun loadImage(imageView: ImageView, avatar_url: String?) {
        Glide.with(imageView.context).load(avatar_url)
            .into(imageView)
    }

}