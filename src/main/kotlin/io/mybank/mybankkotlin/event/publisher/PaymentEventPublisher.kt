package io.mybank.mybankkotlin.event.publisher

import io.mybank.mybankkotlin.entity.Payment
import io.mybank.mybankkotlin.event.PaymentEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class PaymentEventPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    fun create(payment: Payment) = payment.let {
        applicationEventPublisher.publishEvent(PaymentEvent(it, this))
        it
    }

}