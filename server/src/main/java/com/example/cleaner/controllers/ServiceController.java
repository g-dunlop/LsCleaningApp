package com.example.cleaner.controllers;

import com.example.cleaner.models.other.Service;
import com.example.cleaner.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping(value="/services")
    public ResponseEntity<List<Service>> getServices(){
        return new ResponseEntity<>(serviceRepository.findAll(), HttpStatus.OK);
    }
}
