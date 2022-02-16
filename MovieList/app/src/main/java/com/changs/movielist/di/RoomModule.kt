package com.changs.movielist.di

import android.content.Context
import com.changs.movielist.data.local.FilmsDao
import com.changs.movielist.data.local.FilmsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideMovieDao(context: Context): FilmsDao {
        return FilmsDatabase.getDatabase(context)!!.FilmsDao()
    }

}