package com.sage.kotlincp.service

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service


interface ConsumeService {
    fun sendProblem()
    fun addClient(): Boolean
}