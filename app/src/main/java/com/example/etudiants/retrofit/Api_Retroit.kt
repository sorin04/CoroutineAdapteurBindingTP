package com.example.etudiants.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Api_Retroit {
    private const val BASE_URL:String = "https://run.mocky.io/v3/"

    val api: IntEtu = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create()
}