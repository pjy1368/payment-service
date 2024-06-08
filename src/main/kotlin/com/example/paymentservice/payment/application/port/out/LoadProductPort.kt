package com.example.paymentservice.payment.application.port.out

import com.example.paymentservice.payment.domain.Product

interface LoadProductPort {

    suspend fun getProducts(cartId: Long, productIds: List<Long>): List<Product>
}