package io.mybank.mybankkotlin.grpc

import io.grpc.stub.StreamObserver
import io.mybank.mybankkotlin.grpc.funtions.toPayment
import io.mybank.mybankkotlin.grpc.funtions.toPaymentResponse
import io.mybank.mybankkotlin.grpc.payment.Payment
import io.mybank.mybankkotlin.grpc.payment.Payment.PaymentResponse
import io.mybank.mybankkotlin.grpc.payment.PaymentServiceGrpc
import io.mybank.mybankkotlin.service.PaymentService
import org.springframework.stereotype.Service

@Service
class PaymentGrpcService(
    private val paymentService: PaymentService
) : PaymentServiceGrpc.PaymentServiceImplBase() {

    override fun createPayment(
        request: Payment.PaymentRequest,
        responseObserver: StreamObserver<PaymentResponse>
    ) {

        val paymentResponse = paymentService.create(request.toPayment())
            .toPaymentResponse()

        responseObserver.onNext(paymentResponse)
        responseObserver.onCompleted()
    }

}