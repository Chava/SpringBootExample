package com.springboot.app;

import com.springboot.app.controller.CustomerController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTests {

    @Autowired
    private CustomerController controller;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void checkCustomersList() {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/customers",
                String.class)).contains("The list of all customers");
    }

    @Test
    public void checkCustomerDetails() {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/customers?name=Mark+Zuckerberg",
                String.class)).contains("Customer details");
    }

    @Test
    public void checkUnknownCustomerDetails() {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/customers?name=Mark+Zuckerberg!",
                String.class)).contains("No such user");
    }

    @Test
    public void checkDeleteCustomer() {
        restTemplate.delete("http://localhost:" + port + "/customers?name=Mark+Zuckerberg");
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/customers?name=Mark+Zuckerberg",
                String.class)).contains("No such user");
    }

}
