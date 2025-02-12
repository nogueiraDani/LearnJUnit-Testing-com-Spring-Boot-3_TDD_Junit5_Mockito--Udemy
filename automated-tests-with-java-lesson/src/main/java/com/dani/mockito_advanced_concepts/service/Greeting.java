package com.dani.mockito_advanced_concepts.service;

public class Greeting {

    public static String getGreeting(String username, boolean isCustomer) {
        if (isCustomer) {
            return "Dear " + username;
        } else {
            return "Hello " + username;
        }
    }

}
