package io.mybank.mybankkotlin.repository

import io.mybank.mybankkotlin.controller.entity.Account
import java.math.BigDecimal
import java.util.*

interface AccountRepository {

    fun create(account: Account) : Account

    fun lockBalance(id: UUID, value: BigDecimal) : Boolean

    fun findById(id: UUID): Account?

}