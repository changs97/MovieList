package com.changs.movielist.data.local

import android.content.Context
import android.graphics.Movie
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.changs.movielist.data.model.FilmsModelItem

@Database(entities = [FilmsModelItem::class], version = 1)
abstract class FilmsDatabase : RoomDatabase() {

    abstract fun FilmsDao(): FilmsDao

    companion object {
        @Volatile
        private var instance: FilmsDatabase? = null
        fun getDatabase(context: Context):  FilmsDatabase? {
            if (instance == null) {
                synchronized( FilmsDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FilmsDatabase::class.java,
                        "films"
                    ).build()
                }
            }
            return instance
        }
    }
}