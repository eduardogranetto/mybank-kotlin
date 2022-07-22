package io.mybank.mybankkotlin.grpc.funtions

import io.mybank.mybankkotlin.entity.Payment
import io.mybank.mybankkotlin.functions.toLocalDate
import io.mybank.mybankkotlin.functions.toUUID
import io.mybank.mybankkotlin.grpc.payment.Payment.PaymentRequest
import io.mybank.mybankkotlin.grpc.payment.Payment.PaymentResponse.Status

fun PaymentRequest.toPayment() = Payment(
    accountId = accountId.toUUID(),
    value = value.toBigDecimal(),
    date = paymentDate.toLocalDate(),
)

fun Payment.toPaymentResponse() = io.mybank.mybankkotlin.grpc.payment.Payment.PaymentResponse.newBuilder()
    .setAccountId(accountId.toString())
    .setValue(value.toFloat())
    .setPaymentDate(date.toString())
    .setStatus(Status.valueOf(status.name))
    .build()