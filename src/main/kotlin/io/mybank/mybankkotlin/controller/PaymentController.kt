package io.mybank.mybankkotlin.controller

import io.mybank.mybankkotlin.entity.PaymentStatus
import io.mybank.mybankkotlin.entity.PaymentStatus.APPROVED
import io.mybank.mybankkotlin.controller.request.PaymentRequest
import io.mybank.mybankkotlin.service.PaymentService
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity.status
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/v1/accounts/{accountId}/payments")
class PaymentController(
    private val paymentService: PaymentService
) {

    @PostMapping
    fun create(
        @PathVariable accountId: UUID,
        @RequestBody payload: PaymentRequest
    ) = with(paymentService.create(payload.toEntity(accountId))) {
        status(handleCreateHttpStatus(status)).body(this)
    }

    private fun handleCreateHttpStatus(status: PaymentStatus) = if (status == APPROVED) {
        CREATED
    } else {
        BAD_REQUEST
    }

}