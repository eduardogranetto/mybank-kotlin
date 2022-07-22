package io.mybank.mybankkotlin.event

import io.mybank.mybankkotlin.entity.Payment
import org.springframework.context.ApplicationEvent

class PaymentEvent(
    val payment: Payment,
    source: Any
) : ApplicationEvent(source)