package com.slr3073.services;

import com.slr3073.entities.Customer;
import com.slr3073.repositories.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class CustomerService {
    @Autowired
    CustomerDAO customerDAO;

    public void save(Customer customer) {
        System.out.println("save service");
        customerDAO.save(customer);
    }
}
