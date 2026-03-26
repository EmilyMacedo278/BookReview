package com.example.BookReview.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookReview.models.Book;
import com.example.BookReview.models.Review;
import com.example.BookReview.repositories.BookRepository;
import com.example.BookReview.repositories.ReviewRepository;


@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookRepository bookRepository;


    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada com id " + id));
    }

    public List<Review> getReviewsByBookId(Long bookId) {
        return reviewRepository.findByBookid(bookId);
    }

    public Review addReview(Long bookId, Review review) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com id " + bookId));

        review.setBook(book);
        review.setDataAvaliacao(LocalDate.now());

        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review review) {
        Review existingReview = getReviewById(id);

        existingReview.setNota(review.getNota());
        existingReview.setComentario(review.getComentario());

        return reviewRepository.save(existingReview);
    }

    public void deleteReview(Long id) {
        Review review = getReviewById(id);
        reviewRepository.delete(review);
    }
}