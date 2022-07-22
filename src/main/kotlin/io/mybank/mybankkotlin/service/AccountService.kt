package io.mybank.mybankkotlin.service

import io.mybank.mybankkotlin.entity.Account
import io.mybank.mybankkotlin.exception.AccountNotFoundException
import io.mybank.mybankkotlin.repository.AccountRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class AccountService(
    private val accountRepository: AccountRepository
) {

    fun create(account: Account) = accountRepository.create(account)

    fun updateBalance(accountId: UUID, value: BigDecimal) = with(getById(accountId)){
        accountRepository.lockBalance(id, value)
    }

    fun getById(id: UUID) = accountRepository.findById(id) ?: throw AccountNotFoundException(id)

}