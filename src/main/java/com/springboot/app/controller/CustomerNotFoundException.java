package com.springboot.app.controller;

import com.springboot.app.model.CustomerId;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(CustomerId id) {
        super(String.format("User %s is not found", id.toString()));
    }
}

