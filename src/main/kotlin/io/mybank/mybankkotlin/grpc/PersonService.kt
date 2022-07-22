package io.mybank.mybankkotlin.grpc

import io.grpc.stub.StreamObserver
import io.mybank.mybankkotlin.grpc.person.Person
import io.mybank.mybankkotlin.grpc.person.PersonServiceGrpc
import org.springframework.stereotype.Service

@Service
class PersonService : PersonServiceGrpc.PersonServiceImplBase() {

    override fun consultaPessoa(request: Person.PersonRequest?, responseObserver: StreamObserver<Person.PersonResponse>?) {
        val person = Person.PersonResponse
            .newBuilder()
            .setName("Nome de teste")
            .setEmail("teste@teste.com")
            .setId(1).build()
        responseObserver?.onNext(person)
        responseObserver?.onCompleted()
    }

}