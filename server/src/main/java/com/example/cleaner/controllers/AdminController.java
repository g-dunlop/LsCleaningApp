package com.example.cleaner.controllers;

import com.example.cleaner.models.users.Admin;
import com.example.cleaner.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping(value ="/admins")
    public ResponseEntity<List<Admin>> getAdmins(){
        return new ResponseEntity<>(adminRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/admins/{id}")
    public ResponseEntity getAdmin(@PathVariable Long id){
        return new ResponseEntity<>(adminRepository.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "admins/{id}")
    public ResponseEntity<Long> deleteAdmin(@PathVariable Long id){
        adminRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
