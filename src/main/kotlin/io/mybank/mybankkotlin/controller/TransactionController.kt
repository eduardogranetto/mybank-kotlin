package io.mybank.mybankkotlin.controller

import io.mybank.mybankkotlin.service.TransactionService
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/v1/accounts/{accountId}/transactions")
class TransactionController(
    private val transactionService: TransactionService
) {

    @GetMapping
    fun get(
        @PathVariable accountId: UUID,
        @RequestParam(defaultValue = "1") page: Int,
        @RequestParam(defaultValue = "20") size: Int
    ) = ok(transactionService.getByAccount(accountId, PageRequest.of(page, size)))

}