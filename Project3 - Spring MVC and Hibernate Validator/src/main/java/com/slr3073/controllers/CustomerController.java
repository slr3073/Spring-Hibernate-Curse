package com.slr3073.controllers;

import com.slr3073.entities.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer/")
public class CustomerController {
    @RequestMapping("/showForm")
    public String displayForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/customer-form";
    }

    @RequestMapping("/displayCustomer")
    public String displayCustomer(@Valid @ModelAttribute Customer customer, BindingResult result, Model model){
        if(result.hasErrors()) return "customer/customer-form";

        model.addAttribute("customer",customer);
        return "customer/customer-display";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimmerEditor);
    }
}
