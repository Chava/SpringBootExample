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

    private CustomerId buildId(String encodedName) {
        try {
            String[] splitedFullName = URLDecoder.decode(encodedName,
                    StandardCharsets.UTF_8.toString()).split("\\s+");
            return new CustomerId(splitedFullName[0], splitedFullName[1]);
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("Can't find the customer", ex);
        }
    }

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

    @RequestMapping(value = "/customers/{name}", method = RequestMethod.GET)
    public String showCustomerDetails(@PathVariable("name") String name, Model model)  {
        CustomerId id = buildId(name);
        Customer customer = customerService.customerDetails(id);
        model.addAttribute("customer", customer);
        return "details";
    }

    @RequestMapping(value = "/customers/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("name") String name, Model model) {
        CustomerId id = buildId(name);
        customerService.deleteCustomer(id);
    }
}
