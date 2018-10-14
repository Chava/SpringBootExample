package com.springboot.app.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class CustomerId implements Serializable {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    public CustomerId() {}

    public CustomerId(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString(){
        return String.format("<first_name = %s, last_name = %s>", firstName, lastName);
    }
}
