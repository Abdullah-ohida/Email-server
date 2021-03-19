package com.services;

import com.customers.Customer;
import com.exceptions.IsOnFileException;

import java.util.ArrayList;

public class EmailServer {
    private static ArrayList<Customer> customersDatabase;

    public EmailServer() {
        customersDatabase = new ArrayList<>();
    }

    public void register(Customer customer) throws IsOnFileException {
        Customer isValid = EmailServer.findRecipient(customer.getEmailAddress());
        if (!isEmpty(isValid)) throw new IsOnFileException("invalid email address");
        Account account = new Account(customer, customer.getFirstName());
        customer.addAccount(account);
        addAccount(customer);
    }

    private boolean isEmpty(Customer isValid) {
        return isValid == null;
    }

    private void addAccount(Customer customer){
        customersDatabase.add(customer);
    }

    public static Customer findRecipient(String emailAddress){
        Customer isValid = null;
        for(Customer customer : customersDatabase){
            if(isValidCustomer(emailAddress, customer))
                isValid = customer;
        }
        return isValid;
    }

    private static boolean isValidCustomer(String emailAddress, Customer customer) {
        return customer.getEmailAddress().equals(emailAddress);
    }

    public ArrayList<Customer> getRegisteredCustomer(){
        return customersDatabase;
   }
}
