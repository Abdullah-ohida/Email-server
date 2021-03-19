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

    public void forward(Message message, String ...recipientAddress){
        Account.sendMessage(message, recipientAddress);
    }

    public Message getMessageById(int id) {
        Message isValid = null;
        for (Message message : messages){
            if (message.getMessageId() == id)
                isValid = message;
        }
        return isValid;
    }

    public boolean deleteMessage(int messageById){
        return messages.remove(getMessageById(messageById));
    }
}
