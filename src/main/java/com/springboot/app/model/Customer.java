package com.springboot.app.model;

import org.springframework.util.MultiValueMap;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqGen")
    @SequenceGenerator(name = "seqGen", sequenceName = "MY_SEQUENCE", initialValue = 1000)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Embedded
    private CustomerId customerId;

    @Column(name = "email")
    private String email;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, LocalDate dob) {
        this.customerId = new CustomerId(firstName, lastName, dob);
        this.email = email;
    }

    public Customer(@NotNull  MultiValueMap<String,String> map) {
        customerId = new CustomerId(map.getFirst("firstName"), map.getFirst("lastName"), LocalDate.parse(map.getFirst("dob")));
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

    public String getDob() {return customerId.getDob().toString();}

    public long getId() {
        return id;
    }
}
