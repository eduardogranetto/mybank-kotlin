package io.mybank.mybankkotlin.service

import io.mybank.mybankkotlin.controller.entity.Recharge
import org.springframework.stereotype.Service

@Service
class RechargeService(
    private val accountService: AccountService
) {

    fun create(recharge: Recharge) = accountService.updateBalance(recharge.accountId, recharge.value.abs().negate()).let {
        accountService.getById(recharge.accountId)
    }

}
