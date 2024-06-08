package com.example.paymentservice.payment.adapter.`in`.web.view

import com.example.paymentservice.common.WebAdapter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
@WebAdapter
class PaymentController {

    @GetMapping("/success")
    suspend fun successPage(): String {
        return "success"
    }

    @GetMapping("/fail")
    suspend fun failPage(): String {
        return "fail"
    }
}