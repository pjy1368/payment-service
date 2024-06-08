package com.example.paymentservice.payment.adapter.out.web.toss.executor

import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class TossPaymentExecutor (
    private val tossPaymentWebClient: WebClient,
){
    private val uri: String = "/v1/payments/confirm"

    suspend fun execute(paymentKey: String, orderId: String, amount: String): String {
        return tossPaymentWebClient.post()
            .uri(uri)
            .bodyValue("""
                {
                  "paymentKey": "$paymentKey",
                  "orderId": "$orderId",
                  "amount": $amount
                }
            """.trimIndent())
            .retrieve()
            .bodyToMono(String::class.java)
            .awaitSingle()
    }
}