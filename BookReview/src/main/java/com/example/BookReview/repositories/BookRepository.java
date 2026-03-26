package com.example.BookReview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BookReview.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
