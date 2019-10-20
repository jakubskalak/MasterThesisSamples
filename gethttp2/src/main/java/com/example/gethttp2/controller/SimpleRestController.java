package com.example.gethttp2.controller;

import com.example.gethttp2.model.SimpleMessage;
import com.example.gethttp2.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class SimpleRestController {
    private final MessageService messageService;

    public SimpleRestController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/simpleMessage")
    public Mono<SimpleMessage> simpleGet() {
        return Mono.just(messageService.generateRandomSimpleMessage());
    }

}
