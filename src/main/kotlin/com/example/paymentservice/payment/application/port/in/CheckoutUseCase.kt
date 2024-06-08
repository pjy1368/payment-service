package com.example.paymentservice.payment.application.port.`in`

import com.example.paymentservice.payment.domain.CheckoutResult

interface CheckoutUseCase {

    suspend fun checkout(command: CheckoutCommand): CheckoutResult
}