package com.example.test2movie.api

import com.example.test2movie.view.home.popular.model.Popular
import com.example.test2movie.view.home.popular.model.PopularMovieModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("3/movie/popular?api_key=671030f7bacb09cb3d0914df622394d9&language=en-US")
    suspend fun getPopularMovies(@Query("page") page : Int) : Response<PopularMovieModel>
}