package com.services;

import com.customers.Customer;
import com.emailing.Message;

import java.util.ArrayList;
import java.util.List;

public class Account{
    private final String userName;
    private final List<Message> inboxes;
    private final List<Message> drafts;

    public Account(Customer customer, String userName) {
        this.userName = userName;
        inboxes = new ArrayList<>();
        drafts = new ArrayList<>();
    }

    public void sendMessage(Message message, String recipientAddress){
        drafts.add(message);
        Customer recipient = EmailServer.findRecipient(recipientAddress);
        recipient.getAccounts().get(0).getInboxes().add(message);
    }



    public List<Message> getInboxes() {
        return inboxes;
    }

    public List<Message> getDrafts() {
        return drafts;
    }

    public String getUserName() {
        return userName;
    }

}
