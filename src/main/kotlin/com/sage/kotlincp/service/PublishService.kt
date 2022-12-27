package com.sage.kotlincp.service

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service

interface PublishService {
    fun publishProblem(body: String): Boolean
}