package io.mybank.mybankkotlin.grpc

import io.grpc.BindableService
import io.grpc.ServerBuilder
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class GrpcServer(
    private val services: List<BindableService>
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        val serverBuilder = ServerBuilder.forPort(3001)
        services.forEach{
            serverBuilder.addService(it)
        }
        serverBuilder
            .build()
            .start()

    }
}