package io.mybank.mybankkotlin.controller.entity

import java.math.BigDecimal
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.OffsetDateTime.now
import java.util.*
import java.util.UUID.randomUUID

data class Recharge(
    val id: UUID = randomUUID(),
    val accountId: UUID,
    val value: BigDecimal,
    val date: LocalDate,
    val createdAt: OffsetDateTime = now(),
)