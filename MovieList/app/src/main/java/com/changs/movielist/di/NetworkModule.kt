package com.changs.movielist.di

import com.changs.movielist.BuildConfig
import com.changs.movielist.data.remote.Webservice

import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideCompanyApi(
        factory: Converter.Factory
    ): Webservice {
        return Retrofit.Builder()
            .baseUrl("https://ghibliapi.herokuapp.com/")
            .addConverterFactory(factory)
            .build()
            .create(Webservice::class.java)
    }

    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

}