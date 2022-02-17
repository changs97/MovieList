package com.changs.movielist.ui.adapter


import android.graphics.Movie
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.changs.movielist.R
import com.changs.movielist.data.model.FilmsModelItem
import android.widget.CheckBox
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.changs.movielist.databinding.ListItemBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class RecyclerViewAdapter(private val onClick: (FilmsModelItem) -> Unit):
    ListAdapter<FilmsModelItem, RecyclerViewAdapter.MyViewHolder>(MyDiffCallback){

    private var positionCheck = 0
    private var isStartViewCheck = true


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding, onClick)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)



        holder.itemView.findViewById<CheckBox>(R.id.item_favorite)
            .setOnClickListener {
                bookMarkClickListener.onClick(it, current)
            }

        val animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.slide_in_to_left)

        if (isStartViewCheck) {
            if (holder.adapterPosition > 5) isStartViewCheck = false
        } else {
            if (holder.adapterPosition > positionCheck) {
                holder.itemView.animation = animation
            } else {
                holder.itemView.animation = null
            }
        }
        positionCheck = holder.adapterPosition


    }



    inner class MyViewHolder(
        private val binding: ListItemBinding,
        private val onClick: (FilmsModelItem) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(movie: FilmsModelItem) {
            binding.movie = movie
            binding.onClick = onClick


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