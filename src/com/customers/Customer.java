package com.customers;


import com.services.Account;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Register {
    private ArrayList<Account> accounts;

    public Customer(String firstName, String lastName, String emailAddress, String phoneNumber) {
        super(firstName, lastName, emailAddress, phoneNumber);
        accounts = new ArrayList<Account>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
