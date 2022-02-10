package com.changs.movielist.data

import retrofit2.Call
import retrofit2.http.*


interface Webservice {

    @GET("/films")
    fun getFilms(): Call<FilmsModel>

}
