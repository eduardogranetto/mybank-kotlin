package io.mybank.mybankkotlin.event.listener

import io.mybank.mybankkotlin.entity.Transaction
import io.mybank.mybankkotlin.event.RechargeEvent
import io.mybank.mybankkotlin.service.TransactionService
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class CreateTransactionOnRechargeEventListener(
    private val transactionService: TransactionService
) : ApplicationListener<RechargeEvent>{

    override fun onApplicationEvent(event: RechargeEvent){
        with(event.recharge){
            transactionService.create(
                Transaction(
                    accountId = accountId,
                    value = value,
                    transactionTypeId = "RECHARGE"
                )
            )
        }
    }
}