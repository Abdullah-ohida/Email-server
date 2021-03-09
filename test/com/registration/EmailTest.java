package com.registration;

import com.exceptions.NameLengthException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.PatternSyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {
    Register newUser;

    @BeforeEach
    void setUp() {
        newUser = new Register("Ismail", "Abdullah", "tokun@gmail.com", "0905434552");
    }

    @AfterEach
    void tearDown() {
        newUser = null;
    }

    @Test
    void registerEmail_canGetAndSetNewUserFirstName(){
        newUser.setFirstName("Jane");
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
        newUser.setLastName("Joseph");
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
}