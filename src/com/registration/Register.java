package com.registration;

import com.exceptions.NameLengthException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Register {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_PASSWORD_REGEX = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$", Pattern.CASE_INSENSITIVE);
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    final int MINIMUM_LENGTH = 3;
//    private Database<Account> account;
    private String password;

    public Register(String firstName, String lastName, String emailAddress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.length() < MINIMUM_LENGTH) throw new NameLengthException("First name must contain more than two character");
        if(!(firstName.matches("[A-Z][a-zA-Z]*"))) throw new PatternSyntaxException("First name must start with capital letter", firstName, -1);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.length() < MINIMUM_LENGTH) throw new NameLengthException("Last name must contain more than two character");
        if(!(lastName.matches("[a-zA-Z]+(['-][a-zA-Z]+)*")))throw new PatternSyntaxException("Last name must start with capital letter or small letter", firstName, -1);
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        if(!validateEmail(emailAddress)) throw new  PatternSyntaxException("Invalid email", emailAddress, -1);
        this.emailAddress = emailAddress;
    }

    private boolean validateEmail(String emailAddress) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailAddress);
        return matcher.find();
    }

    private boolean validatePassword(String password){
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(password);
        return matcher.find();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(!validatePassword(password)) throw new PatternSyntaxException("Password must greater than five characters, must not contain white space and must contain at least a digit, lower case letter, uppercase case letter, a special character", password, -1);
        this.password = password;
    }

    @Override
    public String toString() {
       StringBuilder customerDetail = new StringBuilder();
       customerDetail.append("First Name: ").append(firstName).append("\n");
       customerDetail.append("Last Name: ").append(lastName).append("\n");
       customerDetail.append("Email-Address: ").append(emailAddress).append("\n");
       customerDetail.append("Phone-Number: ").append(phoneNumber).append("\n\n");
       return customerDetail.toString();
    }
}
