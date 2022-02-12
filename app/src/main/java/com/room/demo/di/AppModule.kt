package com.room.demo.di

import com.room.demo.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideUrl() = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun provideApiServices(url:String):ApiService =
    Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

}