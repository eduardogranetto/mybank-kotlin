package io.mybank.mybankkotlin.functions

import java.time.LocalDate
import java.util.*
import java.util.UUID.fromString

fun String.toUUID(): UUID = fromString(this)

fun String.toLocalDate(): LocalDate = LocalDate.parse(this)