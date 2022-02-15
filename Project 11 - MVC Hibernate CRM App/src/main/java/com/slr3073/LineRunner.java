package com.slr3073;

import com.slr3073.entities.Customer;
import com.slr3073.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LineRunner implements CommandLineRunner {
    @Autowired
    CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {
        customerService.save(new Customer("Romain", "SALVAN", "romain.salvan@g-mail.fr"));
        customerService.save(new Customer("Emma", "Clark", "emma.clark@g-mail.fr"));
        customerService.save(new Customer("Judy", "Larson", "judy.larson@g-mail.fr"));
        customerService.save(new Customer("Pat", "Dupont", "pat.dupont@g-mail.fr"));
    }
}
