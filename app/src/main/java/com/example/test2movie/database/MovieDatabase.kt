package com.example.test2movie.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.test2movie.dao.MovieDao
import com.example.test2movie.view.home.popular.model.Popular

@Database(entities = [Popular::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun getDao() : MovieDao

    companion object{
        @Volatile
        private var movieDataBase : MovieDatabase? = null


        fun getDataBaseInstance(context : Context) : MovieDatabase {
            if(movieDataBase ==null){
                Log.d("zz", "getDataBaseInstance11: ")
                synchronized(this){
                    movieDataBase = Room.databaseBuilder(
                        context,
                        MovieDatabase::class.java,
                        "movie_database"
                    )
                        .allowMainThreadQueries()
                        .build()
                    Log.d("zz", "getDataBaseInstance12: ")
                }

            }
            return movieDataBase!!
        }
    }
}