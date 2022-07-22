package io.mybank.mybankkotlin.event.publisher

import io.mybank.mybankkotlin.entity.Recharge
import io.mybank.mybankkotlin.event.RechargeEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class RechargeEventPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    fun create(recharge: Recharge) = recharge.let {
        applicationEventPublisher.publishEvent(RechargeEvent(it, this))
        it
    }

}