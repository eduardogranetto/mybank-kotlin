package io.mybank.mybankkotlin.service

import io.mybank.mybankkotlin.controller.entity.Payment
import io.mybank.mybankkotlin.controller.entity.PaymentStatus.APPROVED
import io.mybank.mybankkotlin.controller.publisher.PaymentEventPublisher
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val accountService: AccountService,
    private val paymentEventPublisher: PaymentEventPublisher
) {

    fun create(payment: Payment) = accountService.updateBalance(payment.accountId, payment.value.abs()).let {
        payment.copy(
            status = APPROVED
        )
    }.let {
        paymentEventPublisher.create(it)
    }

}
