package io.mybank.mybankkotlin.event

import io.mybank.mybankkotlin.entity.Recharge
import org.springframework.context.ApplicationEvent

class RechargeEvent(
    val recharge: Recharge,
    source: Any
) : ApplicationEvent(source)