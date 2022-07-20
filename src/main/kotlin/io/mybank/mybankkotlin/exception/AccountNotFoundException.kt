package io.mybank.mybankkotlin.exception

import java.util.*

class AccountNotFoundException(id: UUID) : RuntimeException("Account id=$id not found.")