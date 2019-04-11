package com.springboot.app.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findById(long id);
    List<Customer> findByCustomerId(CustomerId customerId);
    void deleteById(long id);
    void deleteByCustomerId(CustomerId customerId);
}
