package com.services;

import com.Notification.MailNotification;
import com.customers.Customer;
import com.emailing.Message;


public class Account{
    private final String userName;
    private final Inbox inbox;
    private static SentBox sentBox;
    private static MailNotification notification;

    public Account(Customer customer, String userName) {
        this.userName = userName;
        inbox = new Inbox();
        sentBox = new SentBox();
    }

    public static void sendMessage(Message message, String ...recipientAddress){
        getSendBox().addMessage(message);
        for (String address : recipientAddress){
            Customer recipient = EmailServer.findRecipient(address);
            send(message, recipient);
            notification = new MailNotification(recipient, message);
        }
    }

    private static void send(Message message, Customer recipient) {;
        recipient.getAccounts().get(0).getInbox().addMessage(message);
    }

    public Inbox getInbox() {
        return inbox;
    }

    public static SentBox getSendBox() {
        return sentBox;
    }

    public String getUserName() {
        return userName;
    }

    public MailNotification getNotification() {
        return notification;
    }
}
