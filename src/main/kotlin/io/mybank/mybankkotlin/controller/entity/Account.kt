package io.mybank.mybankkotlin.controller.entity

import java.math.BigDecimal
import java.time.OffsetDateTime
import java.util.UUID
import java.util.UUID.randomUUID

data class Account(
    val id: UUID = randomUUID(),
    val document: String,
    val createdAt: OffsetDateTime = OffsetDateTime.now(),
    val balance: BigDecimal = BigDecimal.ZERO
)