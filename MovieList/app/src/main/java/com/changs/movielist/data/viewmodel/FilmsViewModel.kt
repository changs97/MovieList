package com.changs.movielist.data.viewmodel

import android.graphics.Movie
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.changs.movielist.data.model.FilmsModelItem
import com.changs.movielist.data.repository.FilmsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class FilmsViewModel  @Inject constructor(
    private val filmsRepository: FilmsRepository
) : ViewModel() {
    private val _movie = MutableLiveData<List<FilmsModelItem>>()
    val movie: LiveData<List<FilmsModelItem>> = _movie

    fun getMovieByRank() {
        viewModelScope.launch {

            _movie.value = filmsRepository.getMovieByRank() as List<FilmsModelItem>?

            Log.d("성공","여긴 뷰모델 ${_movie.value}")
        }
    }

    fun insertBookmark(movie: FilmsModelItem) {
        filmsRepository.insertData(movie)
    }

    fun deleteBookmark(movieId: String) {
        filmsRepository.deleteData(movieId)
    }

    fun isBookMarked(movieId: String): Boolean = filmsRepository.isBookMarked(movieId)

    fun getBookmark() = filmsRepository.getAll()







}