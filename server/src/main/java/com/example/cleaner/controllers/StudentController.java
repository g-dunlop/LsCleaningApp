package com.example.cleaner.controllers;

import com.example.cleaner.models.Student;
import com.example.cleaner.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepo;

    @GetMapping(value ="/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentRepo.findAll(), HttpStatus.OK);

    }

}
