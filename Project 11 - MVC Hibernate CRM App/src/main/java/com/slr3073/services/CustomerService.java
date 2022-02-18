package com.slr3073.services;

import com.slr3073.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void save(Customer customer);
    List<Customer> findAll();
    Optional<Customer> find(long id);
}
