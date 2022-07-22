package io.mybank.mybankkotlin.service

import io.mybank.mybankkotlin.entity.Payment
import io.mybank.mybankkotlin.entity.PaymentStatus.APPROVED
import io.mybank.mybankkotlin.entity.PaymentStatus.REPROVED
import io.mybank.mybankkotlin.event.publisher.PaymentEventPublisher
import io.mybank.mybankkotlin.exception.InsufficientFundsException
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val accountService: AccountService,
    private val paymentEventPublisher: PaymentEventPublisher
) {

    fun create(payment: Payment) = updateAccountBalance(payment).let { paymentStatus ->
        paymentEventPublisher.create(payment).let {
            payment.copy(
                status = paymentStatus
            )
        }
    }

    private fun updateAccountBalance(payment: Payment) = try {
        accountService.updateBalance(payment.accountId, payment.value.abs()).let {
            APPROVED
        }
    }catch (e: InsufficientFundsException){
        REPROVED
    }

}
