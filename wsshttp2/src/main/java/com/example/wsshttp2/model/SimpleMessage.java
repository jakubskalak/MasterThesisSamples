package com.example.wsshttp2.model;

public class SimpleMessage {
    private int value;

    public SimpleMessage(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SimpleMessage{" +
                "value=" + value +
                '}';
    }
}


