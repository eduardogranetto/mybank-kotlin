package io.mybank.mybankkotlin.service

import io.mybank.mybankkotlin.controller.entity.Payment
import io.mybank.mybankkotlin.controller.entity.PaymentStatus.APPROVED
import io.mybank.mybankkotlin.exception.AccountNotFoundException
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val accountService: AccountService
) {

    fun create(payment: Payment) = if(lockBalance(payment)){
        payment.copy(
            status = APPROVED
        )
    } else throw AccountNotFoundException(payment.accountId)

    private fun lockBalance(payment: Payment) = accountService.lockBalance(payment.accountId, payment.value)

}