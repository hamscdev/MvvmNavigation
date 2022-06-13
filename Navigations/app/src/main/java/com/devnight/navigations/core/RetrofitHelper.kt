package com.devnight.navigations.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://private-2a065d-testnapify.apiary-mock.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}