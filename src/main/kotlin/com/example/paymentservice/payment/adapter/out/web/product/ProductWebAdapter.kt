package com.example.paymentservice.payment.adapter.out.web.product

import com.example.paymentservice.common.WebAdapter
import com.example.paymentservice.payment.adapter.out.web.product.client.ProductClient
import com.example.paymentservice.payment.application.port.out.LoadProductPort
import com.example.paymentservice.payment.domain.Product

@WebAdapter
class ProductWebAdapter(
    private val productClient: ProductClient
) : LoadProductPort {
    override suspend fun getProducts(cartId: Long, productIds: List<Long>): List<Product> {
        return productClient.getProducts(cartId, productIds)
    }
}