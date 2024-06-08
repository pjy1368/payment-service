package com.example.paymentservice.payment.adapter.out.persistent.repository

import com.example.paymentservice.payment.domain.PaymentEvent

interface PaymentRepository {

    suspend fun save(paymentEvent: PaymentEvent)
}