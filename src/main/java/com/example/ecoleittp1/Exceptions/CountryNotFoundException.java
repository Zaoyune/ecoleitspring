package com.example.ecoleittp1.Exceptions;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(String messages) {
        super(messages);
    }
}
