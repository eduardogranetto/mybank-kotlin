package io.mybank.mybankkotlin.entity

import java.math.BigDecimal
import java.time.OffsetDateTime
import java.time.OffsetDateTime.now
import java.util.*
import java.util.UUID.randomUUID

data class Transaction(
    val id: UUID = randomUUID(),
    val accountId: UUID,
    val value: BigDecimal,
    val transactionTypeId: String,
    val createdAt: OffsetDateTime = now(),
)