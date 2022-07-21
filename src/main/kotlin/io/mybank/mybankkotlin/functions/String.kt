package io.mybank.mybankkotlin.functions

import java.util.UUID
import java.util.UUID.fromString

fun String.toUUID() = fromString(this)!!