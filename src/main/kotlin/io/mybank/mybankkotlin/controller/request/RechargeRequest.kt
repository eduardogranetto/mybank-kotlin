package io.mybank.mybankkotlin.controller.request

import io.mybank.mybankkotlin.entity.Recharge
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class RechargeRequest(
    val value: BigDecimal,
    val date: LocalDate,
) {
    fun toEntity(accountId: UUID) = Recharge(
        accountId = accountId,
        value = value,
        date = date,
    )
}