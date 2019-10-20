package com.example.resthttp2;

import com.example.resthttp2.model.SimpleMessage;
import com.example.resthttp2.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalTime;

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

    @GetMapping("/sse")
    public Flux<ServerSentEvent<SimpleMessage>> streamEvents() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> ServerSentEvent.<SimpleMessage> builder()
                        .id(String.valueOf(sequence))
                        .event("periodic-event")
                        .data(messageService.generateRandomSimpleMessage())
                        .build());
    }

}
