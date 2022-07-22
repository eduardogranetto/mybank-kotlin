package io.mybank.mybankkotlin.repository

import io.mybank.mybankkotlin.entity.Transaction
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import java.util.UUID

interface TransactionRepository {

    fun create(transaction: Transaction) : Transaction

    fun findByAccountId(accountId: UUID, pageRequest: PageRequest) : Page<Transaction>

}