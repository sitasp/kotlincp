package com.sage.kotlincp.config

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker
class PublishConfig: WebSocketMessageBrokerConfigurer {

    @Override
    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.enableSimpleBroker("/topic/", "/queue/") //prefix for endpoint that client listens message from us
        registry.setApplicationDestinationPrefixes("/app")  //app    //prefix for endpoint that client sends message to us
    }

    @Override
    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/greeting").withSockJS()
        // Registers the endpoint where the connection will take place
//        registry.addEndpoint("/stomp")
            // Allow the origin http://localhost:63343 to send messages to us. (Base URL of the client)
//            .setAllowedOrigins("http://localhost:63343")
            // Enable SockJS fallback options
//            .withSockJS();
    }
}