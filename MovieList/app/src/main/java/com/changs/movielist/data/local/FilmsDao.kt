package com.changs.movielist.data.local

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.changs.movielist.data.model.FilmsModelItem

@Dao
interface FilmsDao {
    //모든 데이터 가져오기
    @androidx.room.Query("SELECT * from films")
    fun getAll(): LiveData<List<FilmsModelItem>>

    //해당 id의 무비 가져오기
    @androidx.room.Query("SELECT * from films WHERE id = :movieId")
    fun isBookmarkChecked(movieId: String?): FilmsModelItem

    //무비 데이터 추가
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertData(movieDetail: FilmsModelItem)

    //해당 id의 무비 삭제
    @androidx.room.Query("DELETE FROM films WHERE id = :movieId")
    fun deleteData(movieId: String)
}