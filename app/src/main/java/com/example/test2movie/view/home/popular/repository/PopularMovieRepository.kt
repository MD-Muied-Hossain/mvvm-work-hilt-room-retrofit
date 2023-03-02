package com.example.test2movie.view.home.popular.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.test2movie.api.ApiInterface
import com.example.test2movie.dao.MovieDao
import com.example.test2movie.view.home.popular.model.Popular
import javax.inject.Inject

class PopularMovieRepository @Inject constructor(
    private val api: ApiInterface,
    var movieDao: MovieDao
) {

    suspend fun getPop(page :Int) = api.getPopularMovies(page)


    suspend fun insertMovie(page:Int,popular: Popular) {
        movieDao.insertPopMovie(popular)
        api.getPopularMovies(page)
    }

}