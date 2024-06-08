package com.example.paymentservice.payment.application.port.out

import com.example.paymentservice.payment.domain.PaymentEvent

interface SavePaymentPort {

    suspend fun save(paymentEvent: PaymentEvent)
}