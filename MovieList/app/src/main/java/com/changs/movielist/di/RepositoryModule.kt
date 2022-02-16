package com.changs.movielist.di

import com.changs.movielist.data.repository.FilmsRepository
import com.changs.movielist.data.repository.FilmsRepositoryImp
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideBookmarkRepository(bookmarkRepository: FilmsRepositoryImp): FilmsRepository


}