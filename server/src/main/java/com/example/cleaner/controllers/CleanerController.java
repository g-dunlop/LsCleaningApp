package com.example.cleaner.controllers;

import com.example.cleaner.models.users.Cleaner;
import com.example.cleaner.repositories.CleanerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CleanerController {

    @Autowired
    private CleanerRepository cleanerRepository;

    @GetMapping(value="/cleaners")
    public ResponseEntity<List<Cleaner>> getCleaners(){
        return new ResponseEntity<>(cleanerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/cleaners/{id}")
    public ResponseEntity getCleaner(@PathVariable Long id){
        return new ResponseEntity<>(cleanerRepository.findById(id), HttpStatus.OK);
    }

}
