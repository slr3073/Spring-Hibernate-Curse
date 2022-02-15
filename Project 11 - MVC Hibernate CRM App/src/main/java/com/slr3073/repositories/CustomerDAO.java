package com.slr3073.repositories;

import com.slr3073.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long>{
}
