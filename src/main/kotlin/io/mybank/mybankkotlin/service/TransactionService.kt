package io.mybank.mybankkotlin.service

import io.mybank.mybankkotlin.entity.Transaction
import io.mybank.mybankkotlin.repository.TransactionRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class TransactionService(
    private val transactionRepository: TransactionRepository
) {

    fun create(transaction: Transaction) = transactionRepository.create(transaction)

    fun getByAccount(accountId: UUID, pageRequest: PageRequest) = transactionRepository.findByAccountId(accountId, pageRequest)

}