package com.springboot.app.controller;

import com.springboot.app.model.Customer;
import com.springboot.app.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public void addCustomer(Customer item){
        customerRepository.save(item);
    }
}
