package com.example.paymentservice.payment.adapter.out.web.product.client

import com.example.paymentservice.payment.domain.Product
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class MockProductClient : ProductClient {
    override suspend fun getProducts(cartId: Long, productIds: List<Long>): List<Product> {
        return productIds.map {
            Product(
                id = it,
                amount = BigDecimal(it * 10000),
                quantity = 2,
                name = "test_product_$it",
                sellerId = 1
            )
        }
    }
}