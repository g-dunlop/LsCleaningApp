package com.example.cleaner.components;

import com.example.cleaner.models.other.Service;
import com.example.cleaner.models.users.Admin;
import com.example.cleaner.models.users.Cleaner;
import com.example.cleaner.models.users.Customer;
import com.example.cleaner.models.other.Review;
import com.example.cleaner.repositories.*;
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

    @Autowired
    ReviewRepository reviewRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args) throws FileNotFoundException {

        Admin admin1 = new Admin( "Bob", "2132134", "bob@bob", "Admin");
        adminRepository.save(admin1);

        Cleaner cleaner1 = new Cleaner( "Bill", "342432", "bill@bill", "Cleaner", 4.5 );
        cleanerRepository.save(cleaner1);

        Customer customer = new Customer( "Robert", "767676", "rob@robert", "Customer", "17 The Lane", "FK54XE");
        customerRepository.save(customer);

        Service service = new Service( "Domestic clean - 2 Hrs", "Mop, bucket, spade", new BigDecimal("50.50"));
        serviceRepository.save(service);

        Review review = new Review("15/07/2022",3.6, "pretty shit",  cleaner1, customer);
        reviewRepository.save(review);

        cleaner1.addService(service);
        cleanerRepository.save(cleaner1);
    }
}
