package com.services;

import com.customers.Customer;

import java.util.ArrayList;
import java.util.List;

public class Account{
    private final String userName;
    private final List<Inbox> inboxes;
    private final List<Draft> drafts;

    public Account(Customer customer, String userName) {
        this.userName = userName;
        inboxes = new ArrayList<>();
        drafts = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public List<Inbox> getInboxes() {
        return inboxes;
    }

    public List<Draft> getDrafts() {
        return drafts;
    }
}
