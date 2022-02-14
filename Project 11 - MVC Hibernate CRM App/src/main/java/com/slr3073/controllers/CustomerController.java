package com.slr3073.controllers;

import com.slr3073.entities.Customer;
import com.slr3073.repositories.CustomerDAO;
import com.slr3073.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping("/customers")
    public String displayCustomerList(){
        Customer c = new Customer("Romain", "SALVAN", "romain.salvan@g-mail.fr");
        customerService.save(c);
        return "customer-list";
    }
}