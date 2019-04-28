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

    private static final String LIST = "The list of all customers";
    private static final String DETAILS = "Customer details";
    private static final String NO_USER_ERROR = "No such user";

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void checkCustomersList() {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/customers",
                String.class)).contains(LIST);
    }

    @Test
    public void checkCustomerDetails() {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/customers/1",
                String.class)).contains(DETAILS);
    }

    @Test
    public void checkUnknownCustomerDetails() {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/customers/100000",
                String.class)).contains(NO_USER_ERROR);
    }

    @Test
    public void checkDeleteCustomer() {
        restTemplate.delete("http://localhost:" + port + "/customers/1");
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/customers/1",
                String.class)).contains(NO_USER_ERROR);
    }
}
