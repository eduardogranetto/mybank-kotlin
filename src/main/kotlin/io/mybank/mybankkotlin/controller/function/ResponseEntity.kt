package io.mybank.mybankkotlin.controller.function

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

fun created(body: Any) = ResponseEntity.status(HttpStatus.CREATED).body(body)