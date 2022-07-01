package com.example.cleaner.components;

import com.example.cleaner.models.Student;
import com.example.cleaner.models.users.Admin;
import com.example.cleaner.repositories.AdminRepository;
import com.example.cleaner.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AdminRepository adminRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args) throws FileNotFoundException {

        Student student = new Student("BArry", "barry@barry.com");
        System.out.println(student);
        studentRepository.save(student);

        Admin admin1 = new Admin(1L, "Bob", "2132134", "bob@bob", "Admin");
        adminRepository.save(admin1);
    }
}
