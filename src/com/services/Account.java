package com.services;

import com.customers.Customer;
import com.emailing.Message;


public class Account{
    private final String userName;
    private final Inbox inbox;
    private static Draft draft;

    public Account(Customer customer, String userName) {
        this.userName = userName;
        inbox = new Inbox();
        draft = new Draft();
    }

    public static void sendMessage(Message message, String ...recipientAddress){
        getDraft().addMessage(message);
        for (String address : recipientAddress){
            Customer recipient = EmailServer.findRecipient(address);
            recipient.getAccounts().get(0).getInbox().addMessage(message);
        }

    }

    public Inbox getInbox() {
        return inbox;
    }

    public static Draft getDraft() {
        return draft;
    }

    public String getUserName() {
        return userName;
    }

}
