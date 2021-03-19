package com.Notification;

import com.customers.Customer;
import com.emailing.Message;

public class MailNotification extends Alert{
    private final String alertTitle;
    private final String senderAddress;
    private final String messageHeader;


    public MailNotification(Customer customer, Message message) {
        super();
        alertTitle = message.getMessageType().toString();
        senderAddress = customer.getEmailAddress();
        messageHeader = message.getSubject();
    }

    @Override
    public String toString() {

        return "Category: " + alertTitle.toUpperCase() + "\n" +
                "From: " + senderAddress + "\n" +
                "Subject: " + messageHeader.toUpperCase() + "\n";
    }
}
