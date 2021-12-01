package com.tingli.autosizedemo.eventbus;

public class FirstEvent {

    private String message;

    public FirstEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}