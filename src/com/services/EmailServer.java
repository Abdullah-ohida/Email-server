package com.services;

import com.customers.Customer;

import java.util.ArrayList;
import java.util.Collection;

public class EmailServer {
    private final ArrayList<Customer> customersDatabase;

    public EmailServer() {
        this.customersDatabase = new ArrayList<>();
    }

    public void register(Customer customer) {
        Account account = new Account(customer, customer.getFirstName());
        customer.addAccount(account);
        addAccount(customer);
    }

    private void addAccount(Customer customer){
        customersDatabase.add(customer);
    }

   public ArrayList<Customer> getRegisteredCustomer(){
        return customersDatabase;
   }
}
