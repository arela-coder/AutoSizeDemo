package com.tingli.autosizedemo.eventbus;

public class SecondEvent {

    private String message;

    public SecondEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}