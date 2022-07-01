package com.example.cleaner.components;

import com.example.cleaner.models.other.Service;
import com.example.cleaner.models.users.Admin;
import com.example.cleaner.models.users.Cleaner;
import com.example.cleaner.models.users.Customer;
import com.example.cleaner.repositories.AdminRepository;
import com.example.cleaner.repositories.CleanerRepository;
import com.example.cleaner.repositories.CustomerRepository;
import com.example.cleaner.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    AdminRepository adminRepository;
    @Autowired
    CleanerRepository cleanerRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ServiceRepository serviceRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args) throws FileNotFoundException {



        Admin admin1 = new Admin(1L, "Bob", "2132134", "bob@bob", "Admin");
        adminRepository.save(admin1);

        Cleaner cleaner1 = new Cleaner(1L, "Bill", "342432", "bill@bill", "Cleaner", 4.5 );
        cleanerRepository.save(cleaner1);

        Customer customer = new Customer(1L, "Robert", "767676", "rob@robert", "Customer", "17 The Lane", "FK54XE");
        customerRepository.save(customer);

        Service service = new Service( "Domestic clean - 2 Hrs", "Mop, bucket, spade", new BigDecimal("50.50"));
        serviceRepository.save(service);
    }
}
