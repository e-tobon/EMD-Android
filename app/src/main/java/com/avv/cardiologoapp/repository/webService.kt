package com.avv.cardiologoapp.repository

import com.avv.cardiologoapp.data.cardioValue
import com.avv.cardiologoapp.utils.AppConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface webService {
    @GET(".json")
    suspend fun getCardioValues(): cardioValue
}

object RetrofitClient{
    val webService by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(webService::class.java)
    }
}