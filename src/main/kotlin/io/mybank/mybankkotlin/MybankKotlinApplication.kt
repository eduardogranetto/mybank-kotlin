package io.mybank.mybankkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MybankKotlinApplication

fun main(args: Array<String>) {
	runApplication<MybankKotlinApplication>(*args)
}
