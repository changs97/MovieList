package com.changs.movielist.data.repository

import android.graphics.Movie
import androidx.lifecycle.LiveData
import com.changs.movielist.data.model.FilmsModelItem

interface FilmsRepository {

    fun getAll(): LiveData<List<FilmsModelItem>>

    fun insertData(movie: FilmsModelItem)

    fun deleteData(movieId: String)

    fun isBookMarked(movieId: String): Boolean

    suspend fun getMovieByRank(): Any





}