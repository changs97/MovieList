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
import android.util.Log
import com.changs.movielist.ui.activity.SecondActivity
import com.changs.movielist.ui.fragment.UpdateInterface
import com.google.android.material.snackbar.Snackbar


class RecyclerViewAdapter(private val dataList : ArrayList<FilmsModelItem>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private var positionCheck = 0
    private var isStartViewCheck = true



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = dataList[position].title
        holder.itemScore.text = dataList[position].rt_score
        holder.itemDirectorName.text = dataList[position].director
        holder.itemDetail.text = dataList[position].description

        Glide.with(holder.itemView.getContext())
            .load(dataList[position].image)
            .into(holder.itemImage)


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


        if(dataList[position].checked){
            holder.itemDetail.visibility = VISIBLE
            Glide.with(holder.itemView.getContext())
                .load(R.drawable.ic_baseline_expand_less_24)
                .into(holder.itemExpandBtn)
        }else{
            holder.itemDetail.visibility = GONE
            Glide.with(holder.itemView.getContext())
                .load(R.drawable.ic_baseline_expand_more_24)
                .into(holder.itemExpandBtn)
        }


        if(dataList[position].checked2){
            Glide.with(holder.itemView.getContext())
                .load(R.drawable.ic_baseline_star2_24)
                .into(holder.itemFavoriteBtn)
        }else{
            Glide.with(holder.itemView.getContext())
                .load(R.drawable.ic_baseline_star_24)
                .into(holder.itemFavoriteBtn)
        }






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
        val itemExpandBtn : ImageButton
        val itemFavoriteBtn : ImageButton

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_content)
            itemScore = itemView.findViewById(R.id.item_score)
            itemDirectorName = itemView.findViewById(R.id.item_directorName)
            itemExpandBtn = itemView.findViewById(R.id.item_expand_btn)
            itemFavoriteBtn = itemView.findViewById(R.id.item_favorite)

            itemFavoriteBtn.setOnClickListener {
                dataList[adapterPosition].checked2 = !dataList[adapterPosition].checked2

                if(dataList[adapterPosition].checked2){
                    Glide.with(itemView.getContext())
                        .load(R.drawable.ic_baseline_star2_24)
                        .into(itemFavoriteBtn)
                }else{
                    Glide.with(itemView.getContext())
                        .load(R.drawable.ic_baseline_star_24)
                        .into(itemFavoriteBtn) }
            }


            itemExpandBtn.setOnClickListener {
                dataList[adapterPosition].checked = !dataList[adapterPosition].checked

                if(dataList[adapterPosition].checked){
                    itemDetail.visibility = VISIBLE
                    Glide.with(itemView.getContext())
                        .load(R.drawable.ic_baseline_expand_less_24)
                        .into(itemExpandBtn)
                }else{
                    itemDetail.visibility = GONE
                    Glide.with(itemView.getContext())
                        .load(R.drawable.ic_baseline_expand_more_24)
                        .into(itemExpandBtn) }


            }

            itemView.setOnLongClickListener {
                val intent = Intent(itemView.context, SecondActivity::class.java)

                val options : ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
                    itemView.context as Activity,
                    Pair.create(itemTitle, "titleTransition"),
                    Pair.create(itemImage, "imageTransition")
                )
                intent.putExtra("SecondActivity",dataList[adapterPosition])
                itemView.context.startActivity(intent, options.toBundle())

                true
            }

            itemView.setOnClickListener{ v: View ->
                val title : String = dataList.get(adapterPosition).title

                Snackbar.make(v, "If you want to check out ${title}'s additional content, click long.",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }

        }

    }


}