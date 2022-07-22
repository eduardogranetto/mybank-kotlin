package io.mybank.mybankkotlin.controller.request

import io.mybank.mybankkotlin.entity.Account

data class AccountRequest(
    val document: String
) {
    fun toEntity() = Account(
        document = document
    )
}