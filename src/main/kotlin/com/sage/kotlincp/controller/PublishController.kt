package com.sage.kotlincp.controller

import com.google.gson.Gson
import com.sage.kotlincp.service.PublishService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageExceptionHandler
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.simp.SimpMessageSendingOperations
import org.springframework.messaging.simp.annotation.SendToUser
import org.springframework.stereotype.Controller
import java.security.Principal


@Controller
class PublishController(
    private val publishService: PublishService
){

    @Autowired
    private val messagingTemplate: SimpMessageSendingOperations? = null

    @MessageMapping("/message")
    @SendToUser("/queue/reply")
    @Throws(Exception::class)
    fun processMessageFromClient(
        @Payload message: String?,
        principal: Principal?
    ): String? {
        //messagingTemplate.convertAndSendToUser(principal.getName(), "/queue/reply", name);
        return Gson().fromJson<Map<*, *>>(message, MutableMap::class.java)["name"].toString()
    }

    @MessageExceptionHandler
    @SendToUser("/queue/errors")
    open fun handleException(exception: Throwable): String? {
        return exception.message
    }
}