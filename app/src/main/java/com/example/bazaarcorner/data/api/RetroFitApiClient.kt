package com.example.bazaarcorner.data.api

import com.example.bazaarcorner.data.service.ProductService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitClient {
    private val apiUrl = "https://dummyjson.com/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

object ApiClient {
    val productService: ProductService by lazy {
        RetroFitClient.retrofit.create(ProductService::class.java)
    }
}