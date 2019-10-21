package com.example.ssehttp2.controller;

import com.example.ssehttp2.model.SimpleMessage;
import com.example.ssehttp2.service.MessageService;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class SimpleRestController {
    private final MessageService messageService;

    public SimpleRestController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/sse")
    public Flux<ServerSentEvent<SimpleMessage>> streamEvents() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> ServerSentEvent.<SimpleMessage> builder()
                        .id(String.valueOf(sequence))
                        .data(messageService.generateRandomSimpleMessage())
                        .build());
    }
}
