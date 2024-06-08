package com.example.paymentservice.payment.adapter.out.persistent

import com.example.paymentservice.common.PersistentAdapter
import com.example.paymentservice.payment.adapter.out.persistent.repository.PaymentRepository
import com.example.paymentservice.payment.application.port.out.SavePaymentPort
import com.example.paymentservice.payment.domain.PaymentEvent
import reactor.core.publisher.Mono

@PersistentAdapter
class PaymentPersistentAdapter (
    private val paymentRepository: PaymentRepository
): SavePaymentPort {
    override suspend fun save(paymentEvent: PaymentEvent) {
        paymentRepository.save(paymentEvent)
    }
}