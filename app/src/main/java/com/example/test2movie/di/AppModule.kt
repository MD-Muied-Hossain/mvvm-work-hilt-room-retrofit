package com.example.test2movie.di

import android.app.Application
import com.example.test2movie.api.ApiInterface
import com.example.test2movie.constant.constant1
import com.example.test2movie.dao.MovieDao
import com.example.test2movie.database.MovieDatabase
import com.itkacher.okprofiler.BuildConfig
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG)
        {
            builder.addInterceptor(OkHttpProfilerInterceptor())
        }
        return builder.build()
    }
    @Provides
    @Singleton
    fun getRetrofitInstance(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(constant1.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun getPopMovieDB(application: Application) : MovieDatabase {
        return MovieDatabase.getDataBaseInstance(application)
    }

    @Provides
    @Singleton
    fun getRetrofitServiceInstance(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun getDao2(db: MovieDatabase) : MovieDao {
        return db.getDao()
    }

}