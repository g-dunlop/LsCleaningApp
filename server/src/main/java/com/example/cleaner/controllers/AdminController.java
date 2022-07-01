package com.example.cleaner.controllers;

import com.example.cleaner.models.Student;
import com.example.cleaner.models.users.Admin;
import com.example.cleaner.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping(value ="/admins")
    public ResponseEntity<List<Admin>> getAllStudents(){
        return new ResponseEntity<>(adminRepository.findAll(), HttpStatus.OK);
    }
}
