package com.example.cleaner.controllers;

import com.example.cleaner.models.other.Booking;
import com.example.cleaner.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value="/bookings")
    public ResponseEntity<List<Booking>> bookings(){
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }
}
