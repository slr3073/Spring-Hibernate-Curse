package com.slr3073.services;

import com.slr3073.entities.Customer;
import com.slr3073.repositories.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDAO customerDAO;

    @Override
    public void save(Customer customer) {
        customerDAO.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Override
    public Optional<Customer> find(long id) {
        return customerDAO.findById(id);
    }

    @Override
    public void deleteById(long id) {
        customerDAO.deleteById(id);
    }
}
