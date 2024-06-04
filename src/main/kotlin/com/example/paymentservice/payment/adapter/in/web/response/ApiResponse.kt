package com.example.paymentservice.payment.adapter.`in`.web.response

import org.springframework.http.HttpStatus

data class ApiResponse<T> (
    val status: Int = 200,
    val message: String = "",
    val data: T? = null
) {

    companion object {
        fun <T> with(httpStatus: HttpStatus, message: String, data: T? = null): ApiResponse<T> {
            return ApiResponse(httpStatus.value(), message, data)
        }
    }
}