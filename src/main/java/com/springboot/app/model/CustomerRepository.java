package com.springboot.app.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findById(long id);
    Stream<Customer> findByCustomerId(CustomerId customerId);
    void deleteById(long id);
    void deleteByCustomerId(CustomerId customerId);
}
