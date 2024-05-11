package com.osmel.bankingappbackend.reppositories;

import com.osmel.bankingappbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
}
