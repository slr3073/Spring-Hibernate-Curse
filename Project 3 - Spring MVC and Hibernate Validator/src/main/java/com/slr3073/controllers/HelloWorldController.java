package com.slr3073.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "hello-world/hello-world-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "hello-world/hello-world";
    }

    @RequestMapping("/processForm2")
    public String displayNameCapsLock(HttpServletRequest request, Model model){
        String msg = "YO " + request.getParameter("firstName").toUpperCase() + " !!!";
        model.addAttribute("message", msg);
        return "hello-world/hello-world";
    }

    @RequestMapping("/processForm3")
    public String displayNameCapsLock2(@RequestParam("firstName") String name, Model model){
        String msg = "YO " + name.toUpperCase() + " !!!";
        model.addAttribute("message", msg);
        return "hello-world/hello-world";
    }

}
