package com.example.bazaarcorner.data.service

import com.example.bazaarcorner.data.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {
    @GET("products/{id}")
    suspend fun getProduct(@Path("id") postId: Int) : Response<Product?>
}