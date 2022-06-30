package com.example.cleaner.components;

import com.example.cleaner.models.Student;
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

    public DataLoader(){

    }

    public void run(ApplicationArguments args) throws FileNotFoundException {

        Student student = new Student("BArry", "barry@barry.com");
        System.out.println(student);
        studentRepository.save(student);
    }
}
