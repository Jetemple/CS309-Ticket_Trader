package com.example.tickettrader;

public class Message {
    private String text;
    private int sent;

    public Message(String text, int sent) {
        this.sent = sent;
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public int getSent() {
        return this.sent;
    }
}
