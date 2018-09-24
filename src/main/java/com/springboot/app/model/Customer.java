package com.springboot.app.model;

import org.springframework.util.MultiValueMap;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Customer {

    @EmbeddedId
    private CustomerId customerId;

    @Column(name = "email")
    private String email;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email) {
        this.customerId = new CustomerId(firstName, lastName);
        this.email = email;
    }

    public Customer(MultiValueMap<String,String> map) {
        customerId = new CustomerId(map.getFirst("firstName"), map.getFirst("lastName"));
        email = map.getFirst("email");
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName(){
        return customerId.getFirstName();
    }

    public String getLastName() {
        return customerId.getLastName();
    }
}
