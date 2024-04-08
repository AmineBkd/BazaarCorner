package com.example.bazaarcorner.data.repository

import com.example.bazaarcorner.data.api.ApiClient
import com.example.bazaarcorner.data.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

class ProductRepository : IProductRepository {
    private val productService = ApiClient.productService
    override suspend fun getProduct(postId: Int): Flow<Response<Product?>> {
        return flow { emit(productService.getProduct(postId)) }
    }
}

interface IProductRepository {
    @GET("products/{id}")
    suspend fun getProduct(@Path("id") postId: Int): Flow<Response<Product?>>
}