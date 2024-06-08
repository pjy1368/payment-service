package com.example.paymentservice.payment.adapter.out.web.product.client

import com.example.paymentservice.payment.domain.Product

interface ProductClient {

    suspend fun getProducts(cartId: Long, productIds: List<Long>): List<Product>
}