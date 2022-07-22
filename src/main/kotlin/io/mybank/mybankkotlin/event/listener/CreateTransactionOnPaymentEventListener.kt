package io.mybank.mybankkotlin.event.listener

import io.mybank.mybankkotlin.entity.Transaction
import io.mybank.mybankkotlin.event.PaymentEvent
import io.mybank.mybankkotlin.service.TransactionService
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class CreateTransactionOnPaymentEventListener(
    private val transactionService: TransactionService
) : ApplicationListener<PaymentEvent>{

    override fun onApplicationEvent(event: PaymentEvent){
        with(event.payment){
            transactionService.create(
                Transaction(
                    accountId = accountId,
                    value = value,
                    transactionTypeId = "PAYMENT"
                )
            )
        }
    }
}