package com.example.BookReview.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookReview.models.Review;
import com.example.BookReview.services.ReviewService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/review")
public class ReviewControllers {
    
    @Autowired
    private ReviewService service;

    @GetMapping
    public List<Review> listAll(){
        return service.getAllReviews();
    }

    @GetMapping("/{id")
    public ResponseEntity<Review> getReviewByBookId(@PathVariable Long id){

    }
}
