package com.registration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @BeforeEach
    void setUp() {
        Register newUser = new Register("Ismail", "Abdullah", 2001, "tokun@gmail.com", "kogi", "Address", "0905434552");
    }

    @AfterEach
    void tearDown() {
        newUser = null;
    }

    @Test
    void registerEmail_canGetAndSetNewUserFirstName(){

    }

    @Test
    void registerEmail_canGetAndSetNewUser(){

    }

    @Test
    void registerEmail_canGetAndSetNewUserAge(){

    }

    @Test
    void registerEmail_canGeNewUserGmailAddress(){

    }

    @Test
    void registerEmail_canGetAndSetNewUserState(){

    }
    @Test
    void registerEmail_canGetAndSetNewUserAddress(){

    }

    @Test
    void registerEmail_canGetAndSetNewUserPhoneNumber(){

    }
}