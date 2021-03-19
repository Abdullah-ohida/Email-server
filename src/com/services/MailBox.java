package com.services;

import com.emailing.Message;

import java.util.ArrayList;

public abstract class MailBox {
    private final ArrayList<Message> messages;

    public MailBox() {
        messages = new ArrayList<>();
    }

    public void addMessage(Message message){
        messages.add(message);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
}
