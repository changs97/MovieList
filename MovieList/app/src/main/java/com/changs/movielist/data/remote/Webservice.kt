package com.changs.movielist.data.remote



import com.changs.movielist.data.model.FilmsModelItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface Webservice {

    @GET("/films")
    suspend fun getMovie(): Response<List<FilmsModelItem>>

}
