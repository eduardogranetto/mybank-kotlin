package io.mybank.mybankkotlin.controller

import io.mybank.mybankkotlin.controller.function.created
import io.mybank.mybankkotlin.controller.request.AccountRequest
import io.mybank.mybankkotlin.controller.request.PaymentRequest
import io.mybank.mybankkotlin.service.AccountService
import io.mybank.mybankkotlin.service.PaymentService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/v1/accounts/{accountId}/payments")
class PaymentController(
    private val paymentService: PaymentService
) {

    @PostMapping
    fun create(
        @PathVariable accountId: UUID,
        @RequestBody payload: PaymentRequest
    ) = created(paymentService.create(payload.toEntity(accountId)))

}