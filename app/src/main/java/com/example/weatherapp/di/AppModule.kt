package com.example.weatherapp.di

import com.example.weatherapp.services.PostService
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    fun providesRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(PostService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}