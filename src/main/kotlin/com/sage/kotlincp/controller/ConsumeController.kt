package com.sage.kotlincp.controller

import com.sage.kotlincp.service.ConsumeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class ConsumeController(
    private val consumeService: ConsumeService
){

    fun connectPeer(): ResponseEntity<Boolean> =
        ResponseEntity(consumeService.addClient(), HttpStatus.CREATED)
}