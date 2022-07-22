package io.mybank.mybankkotlin.entity

import io.mybank.mybankkotlin.entity.PaymentStatus.PENDING
import java.math.BigDecimal
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.OffsetDateTime.now
import java.util.*
import java.util.UUID.randomUUID

data class Payment(
    val id: UUID = randomUUID(),
    val accountId: UUID,
    val value: BigDecimal,
    val date: LocalDate,
    val status: PaymentStatus = PENDING,
    val createdAt: OffsetDateTime = now(),
)