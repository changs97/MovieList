package com.changs.movielist.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.changs.movielist.data.local.FilmsDao
import com.changs.movielist.data.model.FilmsModelItem
import com.changs.movielist.data.remote.Webservice
import com.changs.movielist.ui.activity.SplashActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class FilmsRepositoryImp  @Inject constructor(private val filmsDao : FilmsDao, private val movieApi: Webservice) : FilmsRepository{


    override fun isBookMarked(movieId: String): Boolean {
        return filmsDao.isBookmarkChecked(movieId) != null
    }



    override fun getAll(): LiveData<List<FilmsModelItem>> {
        return filmsDao.getAll()
    }

    override fun insertData(movie: FilmsModelItem) {
        filmsDao.insertData(movie)
    }

    override fun deleteData(movieId: String) {
        filmsDao.deleteData(movieId)
    }

    override suspend fun getMovieByRank() = withContext(Dispatchers.IO) {
        val response = movieApi.getMovie()
        return@withContext if (response.isSuccessful) {
            val body = response.body()!!.sortedByDescending {
                it.rt_score

            }
            Log.d("테스트","성공")
            Log.d("테스트",body.toString())
            body
        } else {
            return@withContext

        }
    }



}