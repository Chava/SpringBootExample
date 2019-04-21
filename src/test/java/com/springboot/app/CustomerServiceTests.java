package com.springboot.app;

import com.springboot.app.controller.CustomerService;
import com.springboot.app.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerServiceTests {

    @Autowired
    CustomerService customerService;

    @Test
    public void contextLoads() {
        assertThat(customerService).isNotNull();
    }


    @Test
    public void checkAddCustomer() {
        Customer customer = new Customer("Sundar",  "Pichai",
                "sundar@google.com", LocalDate.of(1972, Month.JULY, 12));
        customerService.addCustomer(customer);
        List<Customer> customers  = customerService.findAll();
        assertThat(customer).isIn(customers);
     }

    @Test
    public void checkChangeCustomerEmail() {
        Customer customer = new Customer("Sundar",  "Pichai",
                "sundar@google.com", LocalDate.of(1972, Month.JULY, 12));
        customerService.addCustomer(customer);
        Customer customerAnotherEmail = new Customer("Sundar",  "Pichai",
                "pichai@google.com", LocalDate.of(1972, Month.JULY, 12));
        customerService.addCustomer(customerAnotherEmail);

        List<Customer> customers  = customerService.findAll();
        assertThat(customer).isNotIn(customers);
        assertThat(customerAnotherEmail).isIn(customers);
    }
}
