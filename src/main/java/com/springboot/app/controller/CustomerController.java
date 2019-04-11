package com.springboot.app.controller;

import com.springboot.app.model.Customer;
import com.springboot.app.model.CustomerId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String showAllCustomers(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("listOfCustomers", customers);
        return "customers";
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addNewCustomer(@RequestBody MultiValueMap<String, String> parametersMultiMap, Model model) {
        customerService.addCustomer(new Customer(parametersMultiMap));
        List<Customer> customers = customerService.findAll();
        model.addAttribute("listOfCustomers", customers);
        return "customers";
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public String showCustomerDetails(@PathVariable("id") long id, Model model)  {
        Customer customer = customerService.customerDetails(id);
        model.addAttribute("customer", customer);
        return "details";
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("id") long id) {
        customerService.deleteCustomer(id);
    }
}
