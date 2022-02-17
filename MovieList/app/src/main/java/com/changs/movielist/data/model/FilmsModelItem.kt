package com.changs.movielist.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "films")
data class FilmsModelItem (
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id: String,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String,

    @ColumnInfo(name = "director")
    @SerializedName("director")
    val director: String,

    @ColumnInfo(name = "image")
    @SerializedName("image")
    val image: String,

    @SerializedName("producer")
    val producer: String,

    @SerializedName("release_date")
    val release_date: String,

    @ColumnInfo(name = "rt_score")
    @SerializedName("rt_score")
    val rt_score: String,

    @SerializedName("running_time")
    val running_time: String,

    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String
) : Serializable
