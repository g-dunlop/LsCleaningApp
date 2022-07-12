package com.example.cleaner.repositories;

import com.example.cleaner.models.users.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
