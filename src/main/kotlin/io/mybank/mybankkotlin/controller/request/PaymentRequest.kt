package io.mybank.mybankkotlin.controller.request

import io.mybank.mybankkotlin.controller.entity.Payment
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class PaymentRequest(
    val accountId: UUID,
    val value: BigDecimal,
    val date: LocalDate,
) {
    fun toEntity() = Payment(
        accountId = accountId,
        value = value,
        date = date,
    )
}