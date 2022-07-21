package io.mybank.mybankkotlin.controller.publisher

import io.mybank.mybankkotlin.controller.entity.Payment
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class PaymentEventPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    fun create(payment: Payment) = payment.let {
        applicationEventPublisher.publishEvent(payment)
        it
    }

}