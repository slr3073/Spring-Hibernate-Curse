package com.slr3073.services;

import com.slr3073.entities.Customer;
import com.slr3073.repositories.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {
    @Autowired
    CustomerDAO customerDAO;

    public void save(Customer customer) {
        customerDAO.save(customer);
    }
}
