package com.springboot.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerErrorController implements ErrorController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/error")
    public String showNoCustomersFound(HttpServletRequest request){
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
