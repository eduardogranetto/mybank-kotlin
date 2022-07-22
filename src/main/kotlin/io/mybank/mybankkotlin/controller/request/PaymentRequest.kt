package io.mybank.mybankkotlin.controller.request

import io.mybank.mybankkotlin.entity.Payment
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class PaymentRequest(
    val value: BigDecimal,
    val date: LocalDate,
) {
    fun toEntity(accountId : UUID) = Payment(
        accountId = accountId,
        value = value,
        date = date,
    )
}