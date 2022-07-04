package com.example.cleaner.controllers;

import com.example.cleaner.models.other.Review;
import com.example.cleaner.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;

    @GetMapping(value = "/reviews")
    public ResponseEntity<List<Review>> getReviews(){
        return new ResponseEntity<>(reviewRepository.findAll(), HttpStatus.OK);
    }



}
