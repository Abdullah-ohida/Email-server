package com.customers;

import com.emailing.Message;
import com.exceptions.NameLengthException;
import com.services.EmailServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.PatternSyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {
    Customer customer;
    Message message;
    Message newMassage;
    EmailServer server;

    @BeforeEach
    void setUp() {
        customer = new Customer("Ismail", "Abdullah", "andel@gmail.com", "0905434552");
        message = new Message("Application", "ohida@gmail.com", "abdul@gmail.com", "I want to build a software");
        newMassage =  new Message("ohida@gmail.com", "abdul@gmail.com", "I want to build a software");
        server = new EmailServer();
    }

    @AfterEach
    void tearDown() {
        customer = null;
    }

    @Test
    void registerEmail_canGetAndSetNewUserFirstName(){
        try {
            customer.setFirstName("Jane");
        } catch (NameLengthException e) {
            e.printStackTrace();
        }
        assertEquals("Jane", customer.getFirstName());
    }

    @Test
    void registerEmail_firstNameLengthLesserThanThree_ThrowsNameLengthException(){
        assertThrows(NameLengthException.class, ()-> customer.setFirstName("KU"));
    }

    @Test
    void registerEmail_firstNameStartWithSmallLetter_ThrowsPatternSyntaxException(){
        assertThrows(PatternSyntaxException.class, ()-> customer.setFirstName("funke"));
    }

    @Test
    void registerEmail_canGetAndSetNewUserLastName(){
        try {
            customer.setLastName("Joseph");
        } catch (NameLengthException e) {
            e.printStackTrace();
        }
        assertEquals("Joseph", customer.getLastName());
    }

    @Test
    void registerEmail_lastNameLengthLesserThanThree_ThrowsNameLengthException(){
        assertThrows(NameLengthException.class, ()-> customer.setLastName("Ta"));
    }

    @Test
    void registerEmail_lastNameStartWithSmallLetter_ThrowsPatternSyntaxException(){
        assertThrows(PatternSyntaxException.class, ()-> customer.setFirstName("tunji"));
    }

    @Test
    void registerEmail_canGerNewUserGmailAddress(){
        customer.setEmailAddress("Abdullah@gmail.com");
        assertEquals("Abdullah@gmail.com", customer.getEmailAddress());
    }

    @Test
    void registerEmail_emailAddressNotStructuredWell_ThrowsPatternSyntaxException(){
        assertThrows(PatternSyntaxException.class, ()-> customer.setEmailAddress("Trteyey.com"));
    }

    @Test
    void registerEmail_canGetAndSetNewUserPhoneNumber(){
        customer.setPhoneNumber("909898888");
        assertEquals("909898888", customer.getPhoneNumber());
    }

    @Test
    void registerEmail_canGetAndSetNewUserPassword(){
        customer.setPassword("&Troy23");
        assertEquals("&Troy23", customer.getPassword());
    }

    @Test
    void registerEmail_passwordNotStrong_ThrowsPatternSyntaxException(){
        assertThrows(PatternSyntaxException.class, ()-> customer.setPassword("7hjjew"));
    }


    @Test
    void registerEmail_canDisplayCustomerDetails(){
        assertEquals("First Name: Ismail\nLast Name: Abdullah\nEmail-Address: andel@gmail.com\nPhone-Number: 0905434552\n\n", customer.toString());
    }

    @Test
    void message_canNotBeNullAfterConstruction(){
        assertNotNull(message);
    }

    @Test
    void message_recipientCanBeSet(){
        message.setRecipient("Kunle@gmail.com");
        assertEquals(message.getRecipient(), "Kunle@gmail.com");
    }

    @Test
    void message_senderCanBeSet(){
        message.setSender("Kunle@gmail.com");
        assertEquals(message.getSender(), "Kunle@gmail.com");
    }

    @Test
    void message_canAddSubjectToEmail(){
        message.setSubject("Empowerment");
        assertEquals(message.getSubject(), "Empowerment");
    }

    @Test
    void message_canAddContentToEmail(){
        message.setContent("Your mind is the center of miracle");
        assertEquals(message.getContent(), "Your mind is the center of miracle");
    }

    @Test
    void message_canPrintOutMessage(){
        assertEquals(message.toString(), "From: abdul@gmail.com\nTo: ohida@gmail.com\nSubject: Application\nContent: I want to build a software\n");
    }

    @Test
    void message_canShowMessageWithoutSubject(){
        assertEquals(newMassage.toString(), "From: abdul@gmail.com\nTo: ohida@gmail.com\nSubject: \nContent: I want to build a software\n");
    }

    @Test
    void emailServer_canRegisterCustomers(){
        server.register(customer);
        assertTrue(server.getRegisteredCustomer().contains(customer));
        assertTrue(customer.getAccounts().contains(customer.getAccounts().get(0)));
    }

}