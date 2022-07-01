package com.example.cleaner.components;

import com.example.cleaner.models.users.Admin;
import com.example.cleaner.models.users.Cleaner;
import com.example.cleaner.repositories.AdminRepository;
import com.example.cleaner.repositories.CleanerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    AdminRepository adminRepository;
    @Autowired
    CleanerRepository cleanerRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args) throws FileNotFoundException {



        Admin admin1 = new Admin(1L, "Bob", "2132134", "bob@bob", "Admin");
        adminRepository.save(admin1);

        Cleaner cleaner1 = new Cleaner(1L, "Bill", "342432", "bill@bill", "Cleaner", 4.5 );
        cleanerRepository.save(cleaner1);
    }
}
