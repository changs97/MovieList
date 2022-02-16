package com.changs.movielist.ui.adapter

import android.app.ActivityOptions
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.changs.movielist.R
import com.changs.movielist.data.model.FilmsModelItem
import android.util.Pair
import android.app.Activity
import android.graphics.Movie
import android.util.Log
import android.widget.CheckBox
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.changs.movielist.databinding.ListItemBinding
import com.changs.movielist.ui.activity.SecondActivity
import com.changs.movielist.ui.fragment.UpdateInterface
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class RecyclerViewAdapter(): ListAdapter<FilmsModelItem, RecyclerViewAdapter.MyViewHolder>(MyDiffCallback){

    private var positionCheck = 0
    private var isStartViewCheck = true


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))

        holder.itemView.findViewById<CheckBox>(R.id.item_favorite)
            .setOnClickListener {
                bookMarkClickListener.onClick(it, getItem(position))
            }
    }



    inner class MyViewHolder(
        private val binding: ListItemBinding,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: FilmsModelItem) {
            binding.movie = movie


            CoroutineScope(Dispatchers.IO).launch {
                //해당 무비의 데이터가 null만 아니면 true
                //북마크 취소를 하면 삭제 처리 되니깐 null
                binding.itemFavorite.isChecked = bookMarkClickListener.setChecked(movie)
            }
        }
    }


    object MyDiffCallback : DiffUtil.ItemCallback<FilmsModelItem>() {
        override fun areItemsTheSame(oldItem: FilmsModelItem, newItem: FilmsModelItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FilmsModelItem, newItem: FilmsModelItem): Boolean {
            return oldItem == newItem
        }
    }

    interface ItemClickListener {
        fun onClick(view: View, movie: FilmsModelItem)

        fun setChecked(movie: FilmsModelItem): Boolean
    }

    private lateinit var bookMarkClickListener: ItemClickListener

    fun setBookMarkClickListener(bookMarkClickListener: ItemClickListener) {
        this.bookMarkClickListener = bookMarkClickListener
    }



}