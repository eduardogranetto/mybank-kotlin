package io.mybank.mybankkotlin.controller

import io.mybank.mybankkotlin.controller.function.created
import io.mybank.mybankkotlin.controller.request.AccountRequest
import io.mybank.mybankkotlin.controller.request.PaymentRequest
import io.mybank.mybankkotlin.service.AccountService
import io.mybank.mybankkotlin.service.PaymentService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/payments")
class PaymentController(
    private val paymentService: PaymentService
) {

    @PostMapping
    fun create(@RequestBody payload: PaymentRequest) = created(paymentService.create(payload.toEntity()))

}