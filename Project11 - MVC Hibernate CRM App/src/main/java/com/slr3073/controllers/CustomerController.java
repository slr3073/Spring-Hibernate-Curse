package com.slr3073.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CustomerController {
    @RequestMapping("/customers")
    public String displayCustomerList(){
        return "customer-list";
    }
}
