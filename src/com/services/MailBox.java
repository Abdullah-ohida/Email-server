package com.services;

import com.emailing.Message;
import com.exceptions.MailBoxUnderFlowException;

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

    public boolean deleteMessage(int messageById) throws MailBoxUnderFlowException {
        if(messages.size() == 0) throw new MailBoxUnderFlowException("Inbox is empty");
        return messages.remove(getMessageById(messageById));
    }

    public void deleteAllMessage() throws MailBoxUnderFlowException {
        if(messages.size() == 0) throw new MailBoxUnderFlowException("Inbox is empty");
        messages.clear();
    }
}
