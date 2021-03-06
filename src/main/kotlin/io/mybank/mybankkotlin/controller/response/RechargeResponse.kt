package io.mybank.mybankkotlin.controller.response

import io.mybank.mybankkotlin.entity.Recharge
import java.math.BigDecimal

data class RechargeResponse(
    val recharge: Recharge,
    val balance: BigDecimal
)