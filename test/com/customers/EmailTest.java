package com.customers;

import com.emailing.Message;
import com.exceptions.NameLengthException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.PatternSyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {
   Customer newUser;
    Message composeEmail;
    Message newMassage;

    @BeforeEach
    void setUp() {
        newUser = new Customer("Ismail", "Abdullah", "andel@gmail.com", "0905434552");
        composeEmail = new Message("Application", "ohida@gmail.com", "abdul@gmail.com", "I want to build a software");
        newMassage =  new Message("ohida@gmail.com", "abdul@gmail.com", "I want to build a software");

    }

    @AfterEach
    void tearDown() {
        newUser = null;
    }

    @Test
    void registerEmail_canGetAndSetNewUserFirstName(){
        try {
            newUser.setFirstName("Jane");
        } catch (NameLengthException e) {
            e.printStackTrace();
        }
        assertEquals("Jane", newUser.getFirstName());
    }

    @Test
    void registerEmail_firstNameLengthLesserThanThree_ThrowsNameLengthException(){
        assertThrows(NameLengthException.class, ()-> newUser.setFirstName("KU"));
    }

    @Test
    void registerEmail_firstNameStartWithSmallLetter_ThrowsPatternSyntaxException(){
        assertThrows(PatternSyntaxException.class, ()-> newUser.setFirstName("funke"));
    }

    @Test
    void registerEmail_canGetAndSetNewUserLastName(){
        try {
            newUser.setLastName("Joseph");
        } catch (NameLengthException e) {
            e.printStackTrace();
        }
        assertEquals("Joseph", newUser.getLastName());
    }

    @Test
    void registerEmail_lastNameLengthLesserThanThree_ThrowsNameLengthException(){
        assertThrows(NameLengthException.class, ()-> newUser.setLastName("Ta"));
    }

    @Test
    void registerEmail_lastNameStartWithSmallLetter_ThrowsPatternSyntaxException(){
        assertThrows(PatternSyntaxException.class, ()-> newUser.setFirstName("tunji"));
    }

    @Test
    void registerEmail_canGerNewUserGmailAddress(){
        newUser.setEmailAddress("Abdullah@gmail.com");
        assertEquals("Abdullah@gmail.com", newUser.getEmailAddress());
    }

    @Test
    void registerEmail_emailAddressNotStructuredWell_ThrowsPatternSyntaxException(){
        assertThrows(PatternSyntaxException.class, ()-> newUser.setEmailAddress("Trteyey.com"));
    }

    @Test
    void registerEmail_canGetAndSetNewUserPhoneNumber(){
        newUser.setPhoneNumber("909898888");
        assertEquals("909898888", newUser.getPhoneNumber());
    }

    @Test
    void registerEmail_canGetAndSetNewUserPassword(){
        newUser.setPassword("&Troy23");
        assertEquals("&Troy23", newUser.getPassword());
    }

    @Test
    void registerEmail_passwordNotStrong_ThrowsPatternSyntaxException(){
        assertThrows(PatternSyntaxException.class, ()-> newUser.setPassword("7hjjew"));
    }


    @Test
    void registerEmail_canDisplayCustomerDetails(){
        assertEquals("First Name: Ismail\nLast Name: Abdullah\nEmail-Address: andel@gmail.com\nPhone-Number: 0905434552\n\n", newUser.toString());
    }

    @Test
    void message_canNotBeNullAfterConstruction(){
        assertNotNull(composeEmail);
    }

    @Test
    void message_recipientCanBeSet(){
        composeEmail.setRecipient("Kunle@gmail.com");
        assertEquals(composeEmail.getRecipient(), "Kunle@gmail.com");
    }

    @Test
    void message_senderCanBeSet(){
        composeEmail.setSender("Kunle@gmail.com");
        assertEquals(composeEmail.getSender(), "Kunle@gmail.com");
    }

    @Test
    void message_canAddSubjectToEmail(){
        composeEmail.setSubject("Empowerment");
        assertEquals(composeEmail.getSubject(), "Empowerment");
    }

    @Test
    void message_canAddContentToEmail(){
        composeEmail.setContent("Your mind is the center of miracle");
        assertEquals(composeEmail.getContent(), "Your mind is the center of miracle");
    }

    @Test
    void message_canPrintOutMessage(){
        assertEquals(composeEmail.toString(), "From: abdul@gmail.com\nTo: ohida@gmail.com\nSubject: Application\nContent: I want to build a software\n");
    }

    @Test
    void message_canShowMessageWithoutSubject(){
        assertEquals(newMassage.toString(), "From: abdul@gmail.com\nTo: ohida@gmail.com\nSubject: \nContent: I want to build a software\n");
    }

}