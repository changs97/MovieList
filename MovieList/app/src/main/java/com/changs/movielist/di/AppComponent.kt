package com.changs.movielist.di

import android.content.Context
import com.changs.movielist.ui.activity.SecondActivity
import com.changs.movielist.ui.fragment.CenterFragment
import com.changs.movielist.ui.fragment.LeftFragment
import com.changs.movielist.ui.fragment.RightFragment

import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class, RoomModule::class, NetworkModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(fragment: LeftFragment)
    fun inject(fragment: CenterFragment)
    fun inject(activity : SecondActivity)
    fun inject(fragment: RightFragment)

}