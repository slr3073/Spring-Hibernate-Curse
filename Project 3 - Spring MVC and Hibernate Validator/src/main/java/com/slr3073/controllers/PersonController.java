package com.slr3073.controllers;

import com.slr3073.entities.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {
    @RequestMapping("/showForm")
    public String showForm(Model model){
        // On rajoute notre attribut qui sera utilisable dans la vue
        model.addAttribute("person", new Person());
        return "person/person-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("person") Person person){
        return "/person/display-person";
    }
}
