package com.example.bazaarcorner.data.usecase.product

import com.example.bazaarcorner.data.model.Product
import com.example.bazaarcorner.data.repository.ProductRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.concurrent.Flow

class GetProductUseCase {
    private val productRepository = ProductRepository()
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    suspend operator fun invoke(id: Int) = flow {
        productRepository.getProduct(id).flowOn(ioDispatcher).collect {
            when (it.isSuccessful) {
                true -> {
                    emit(it.body())
                }

                false -> {
                    emit(null)
                }
            }
        }
    }
}