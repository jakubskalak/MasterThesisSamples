package com.example.gethttp2.service;


import com.example.gethttp2.model.SimpleMessage;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MessageService {
    private Random randomGenerator;

    public MessageService() {
        randomGenerator = new Random();
    }

    public SimpleMessage generateRandomSimpleMessage() {
        return new SimpleMessage(randomGenerator.nextInt());
    }
}
