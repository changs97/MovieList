package com.changs.movielist.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.changs.movielist.R
import com.changs.movielist.data.Films
import com.google.android.material.snackbar.Snackbar

class RecyclerViewAdapter(private val dataList : ArrayList<Films>, private val fragmentType : Int): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //여기서 바인드
        when(fragmentType) {
            1 -> {}
            2 -> {}
            3 -> {}
            else -> {}
        }

/*        val animation = AnimationUtils.loadAnimation(MainActivity() as Context, R.anim.slide_in_to_left)
        holder.itemView.animation = animation*/


    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage : ImageView
        val itemTitle : TextView
        val itemDetail : TextView
        val itemScore : TextView
        val itemDirectorName : TextView
        val itemBtn : ImageButton

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_content)
            itemScore = itemView.findViewById(R.id.item_score)
            itemDirectorName = itemView.findViewById(R.id.item_directorName)
            itemBtn = itemView.findViewById(R.id.item_btn)

            itemBtn.setOnClickListener{ v: View ->
                val position : Int = adapterPosition

                //여기서 즐겨찾기 기능 액션

                Snackbar.make(v, "Click detected on item $position",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        }

    }
}