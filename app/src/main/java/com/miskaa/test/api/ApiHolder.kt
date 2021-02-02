package com.miskaa.test.api

import com.miskaa.test.classes.RegionResults
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl("https://restcountries.eu/rest/v2/region/")
    .build()

interface ApiHolder {

    @GET("asia")
    fun getCountryList(): Call<ArrayList<RegionResults>>
}

object Api {
    val retrofitService: ApiHolder by lazy {
        retrofit.create(ApiHolder::class.java)
    }
}