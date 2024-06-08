package com.example.paymentservice.payment.adapter.`in`.web.view

import com.example.paymentservice.common.IdempotencyCreator
import com.example.paymentservice.common.WebAdapter
import com.example.paymentservice.payment.adapter.`in`.web.request.CheckoutRequest
import com.example.paymentservice.payment.application.port.`in`.CheckoutCommand
import com.example.paymentservice.payment.application.port.`in`.CheckoutUseCase
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@WebAdapter
@Controller
class CheckoutController (
    private val checkoutUseCase: CheckoutUseCase
) {

    @GetMapping("/")
    suspend fun checkoutPage(request: CheckoutRequest, model: Model): String {
        val command = CheckoutCommand(
            cartId = request.cartId,
            buyerId = request.buyerId,
            productIds = request.productIds,
            idempotencyKey = IdempotencyCreator.create(request)
        )

        return checkoutUseCase.checkout(command)
            .let {
                model.addAttribute("orderId", it.orderId)
                model.addAttribute("orderName", it.orderName)
                model.addAttribute("amount", it.amount)
                "checkout"
            }
    }
}