package com.changs.movielist

import android.app.Application
import com.changs.movielist.di.AppComponent
import com.changs.movielist.di.DaggerAppComponent


class MyApplication : Application() {

    val appComponent: AppComponent by lazy {

        DaggerAppComponent.factory().create(applicationContext)
    }

}