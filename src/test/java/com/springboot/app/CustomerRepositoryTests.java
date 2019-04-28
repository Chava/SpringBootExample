package com.springboot.app;

import com.springboot.app.model.Customer;
import com.springboot.app.model.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTests {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void injectedComponentsAreNotNull() {
        assertThat(testEntityManager).isNotNull();
        assertThat(customerRepository).isNotNull();
    }

    @Test
    public void checkCustomerCanBePersisted(){
        Customer customer = new Customer("Sundar",  "Pichai",
                "sundar@google.com", LocalDate.of(1972, Month.JULY, 12));
        testEntityManager.persistAndFlush(customer);
        List<Customer> customers  = customerRepository.findAll();
        assertThat(customer).isIn(customers);
    }
}
