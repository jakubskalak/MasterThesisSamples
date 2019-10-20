package com.example.wsshttp2.websocket;

import com.example.wsshttp2.service.MessageService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SimpleWebSocketHandler implements WebSocketHandler {
    private final
    MessageService messageService;

    public SimpleWebSocketHandler(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        Flux<WebSocketMessage> output = session.receive()
                .map(webSocketMessage -> session.textMessage("Received: " + webSocketMessage.getPayloadAsText() +
                        " Sending: " + messageService.generateRandomSimpleMessage().toString()));

        return session.send(output);
    }
}
