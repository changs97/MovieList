package com.changs.roomdemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.changs.movielist.data.Films
import com.changs.movielist.data.FilmsDao


@Database(entities = [(Films::class)], version = 1)
abstract class FilmsRoomDatabase: RoomDatabase() {

    abstract fun filmsDao(): FilmsDao

    companion object {

        private var INSTANCE: FilmsRoomDatabase? = null

        internal fun getDatabase(context: Context): FilmsRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(FilmsRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE =
                            Room.databaseBuilder<FilmsRoomDatabase>(
                                context.applicationContext,
                                FilmsRoomDatabase::class.java,
                                "films_database").build()
                    }
                }
            }
            return INSTANCE
        }
    }
}