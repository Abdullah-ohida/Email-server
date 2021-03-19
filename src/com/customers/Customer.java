package com.customers;


import com.services.Account;

import java.util.ArrayList;

public class Customer extends Register{
   private ArrayList<Account> accounts;

    public Customer(String firstName, String lastName, String emailAddress, String phoneNumber) {
        super(firstName, lastName, emailAddress, phoneNumber);
        accounts = new ArrayList<Account>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
}
