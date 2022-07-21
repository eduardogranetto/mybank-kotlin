package io.mybank.mybankkotlin.controller

import io.mybank.mybankkotlin.controller.function.created
import io.mybank.mybankkotlin.controller.request.RechargeRequest
import io.mybank.mybankkotlin.controller.response.RechargeResponse
import io.mybank.mybankkotlin.service.RechargeService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/v1/accounts/{accountId}/recharges")
class RechargeController(
    private val rechargeService: RechargeService
) {

    @PostMapping
    fun create(
        @PathVariable accountId: UUID,
        @RequestBody payload: RechargeRequest
    ) = with(payload.toEntity(accountId)) {
        created(
            RechargeResponse(
                recharge = this,
                balance = rechargeService.create(this).balance
            )
        )
    }

}