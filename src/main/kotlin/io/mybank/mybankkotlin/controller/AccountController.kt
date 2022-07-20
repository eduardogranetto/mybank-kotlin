package io.mybank.mybankkotlin.controller

import io.mybank.mybankkotlin.controller.function.created
import io.mybank.mybankkotlin.controller.request.AccountRequest
import io.mybank.mybankkotlin.service.AccountService
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/v1/accounts")
class AccountController(
    private val accountService: AccountService
) {

    @PostMapping
    fun create(@RequestBody payload: AccountRequest) = created(accountService.create(payload.toEntity()))

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID) = ok(accountService.getById(id))

}