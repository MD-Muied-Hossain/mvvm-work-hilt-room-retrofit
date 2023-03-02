package com.example.test2movie.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.test2movie.view.home.popular.model.Popular

@Dao
interface MovieDao {

    @Insert
    suspend fun insertPopMovie(popular: Popular)

    @Query("SELECT * FROM PopularMovie_TBL")
    suspend fun getList() : List<Popular>

}