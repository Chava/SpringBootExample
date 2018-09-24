package com.springboot.app.controller;

import com.springboot.app.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value ="/customers", method = RequestMethod.GET)
    public String showAllCustomers(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("listOfCustomers", customers);
        return "customers";
    }


    @RequestMapping(value ="/customers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addNewCustomer(@RequestBody MultiValueMap<String,String> parametersMultiMap, Model model) {
        customerService.addCustomer(new Customer(parametersMultiMap));
        List<Customer> customers = customerService.findAll();
        model.addAttribute("listOfCustomers", customers);
        return "customers";
    }
}
