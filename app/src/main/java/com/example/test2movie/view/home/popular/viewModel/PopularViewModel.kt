package com.example.test2movie.view.home.popular.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.test2movie.dao.MovieDao
import com.example.test2movie.database.MovieDatabase
import com.example.test2movie.view.home.popular.model.Popular
import com.example.test2movie.view.home.popular.model.PopularMovieModel
import com.example.test2movie.view.home.popular.model.PopularMovieResult
import com.example.test2movie.view.home.popular.repository.PopularMovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularViewModel @Inject constructor(
    private val repository: PopularMovieRepository
) : ViewModel() {


    val _popular = MutableLiveData<PopularMovieModel>()
    val _poplar_LiveDataObj: LiveData<PopularMovieModel>
        get() = _popular

    /*init {
        getPopularMoviessss(1)
    }*/

    fun getPopularMoviessss(page:Int) {
        viewModelScope.launch {
                repository.getPop(page).let { response ->
                    if (response.isSuccessful) {
                        _popular.postValue(response.body())
                        response.body().let {
                            it?.results?.forEach {
                                val insert = Popular(
                                    id = it.id,
                                    title = it.original_title
                                )
                                Log.d("pp", "getPopularMoviessss: " + insert)
                                insertInToDB(page,insert)
                            }
                        }
                        Log.d("himu", "ase : " + _popular.postValue(response.body()))
                    }
                }
        }
    }

    suspend fun insertInToDB(page: Int,popular: Popular) {

        repository.insertMovie(page,popular)

    }

}



