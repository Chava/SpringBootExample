package com.springboot.app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Embeddable
public class CustomerId implements Serializable {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "dob", columnDefinition="DATE", nullable = false)
    private LocalDate dob;

    public CustomerId() {}

    public CustomerId(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDob() {return dob; }

    @Override
    public String toString(){
        return String.format("<first_name = %s, last_name = %s, dob = %s>", firstName, lastName, dob);
    }
}
