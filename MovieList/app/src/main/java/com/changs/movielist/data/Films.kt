package com.changs.movielist.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "films")
data class Films (
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "filmsId")
    var id: Int,
    val title: String?,
    val checked : Boolean? = false
    )
