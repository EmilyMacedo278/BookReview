package com.example.BookReview.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.BookReview.models.Review;

import com.example.BookReview.services.ReviewService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @GetMapping
    public List<Review> listAll() {
        return service.getAllReviews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        log.info("Obtendo avaliação com id {}", id);
        return ResponseEntity.ok(service.getReviewById(id));
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Review>> getReviewsByBookId(@PathVariable Long bookId) {
        log.info("Obtendo avaliações do livro {}", bookId);
        return ResponseEntity.ok(service.getReviewsByBookId(bookId));
    }

    @PostMapping("/book/{bookId}")
    public ResponseEntity<Review> createReview(@PathVariable Long bookId, @RequestBody Review review) {
        log.info("Criando avaliação para o livro {}", bookId);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.addReview(bookId, review));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review review) {
        log.info("Atualizando avaliação com id {}", id);
        return ResponseEntity.ok(service.updateReview(id, review));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        log.info("Deletando avaliação com id {}", id);
        service.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}