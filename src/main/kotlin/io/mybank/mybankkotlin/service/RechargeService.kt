package io.mybank.mybankkotlin.service

import io.mybank.mybankkotlin.entity.Recharge
import io.mybank.mybankkotlin.event.publisher.RechargeEventPublisher
import org.springframework.stereotype.Service

@Service
class RechargeService(
    private val accountService: AccountService,
    private val rechargeEventPublisher: RechargeEventPublisher
) {

    fun create(
        recharge: Recharge
    ) = accountService.updateBalance(recharge.accountId, recharge.value.abs().negate())
        .let {
            rechargeEventPublisher.create(recharge)
        }.let {
            accountService.getById(recharge.accountId)
        }

}
