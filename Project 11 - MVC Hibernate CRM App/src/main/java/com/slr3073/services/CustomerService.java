package com.slr3073.services;

import com.slr3073.entities.Customer;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);
    List<Customer> findAll();
}
