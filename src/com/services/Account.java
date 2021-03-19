package com.services;

import com.customers.Customer;
import com.emailing.Message;

import java.util.ArrayList;
import java.util.List;

public class Account{
    private final String userName;
    private final Inbox inbox;
    private final Draft draft;

    public Account(Customer customer, String userName) {
        this.userName = userName;
        inbox = new Inbox();
        draft = new Draft();
    }

    public void sendMessage(Message message, String recipientAddress){
        getDraft().addMessage(message);
        Customer recipient = EmailServer.findRecipient(recipientAddress);
        recipient.getAccounts().get(0).getInbox().addMessage(message);
    }

    public Inbox getInbox() {
        return inbox;
    }

    public Draft getDraft() {
        return draft;
    }

    public String getUserName() {
        return userName;
    }

}
