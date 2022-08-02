package com.oa.sessiontask

import com.example.example.Store
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object Network {
    var retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl("https://www.cheapshark.com/api/1.0/")
        .build()
    val service = retrofit.create(EndPoints::class.java)
}

interface EndPoints {
    @GET("stores")
    suspend fun getStores(): List<Store>
}
