package com.springboot.app.controller;

import com.springboot.app.model.Customer;
import com.springboot.app.model.CustomerId;
import com.springboot.app.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void addCustomer(Customer item) {
        CustomerId id = item.getCustomerId();
        if (!CollectionUtils.isEmpty(customerRepository.findByCustomerId(id))) {
            customerRepository.deleteByCustomerId(id);
        }
        customerRepository.save(item);
    }

    public Customer customerDetails(CustomerId id) {
        List<Customer> customer =  customerRepository.findByCustomerId(id);
        if(CollectionUtils.isEmpty(customer)){
            throw new CustomerNotFoundException(id);
        }
        return customerRepository.findByCustomerId(id).get(0);
    }

    public void deleteCustomer(CustomerId id) {
        customerRepository.deleteByCustomerId(id);
    }
}
