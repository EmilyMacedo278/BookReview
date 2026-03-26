package com.example.BookReview.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.BookReview.models.Book;
import com.example.BookReview.repositories.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository repository;

    public List<Book> getAllBook(){
        return repository.findAll();
    }

    public Book addBook(Book book){
        return repository.save(book);
    
    }

    public Book getBookById(Long id){
        return findBookById(id);
    }
    public void deleteBook(Long id) {
        findBookById(id);
            repository.deleteById(id);
    }

    public Book updateBook(Long id, Book newBook) {
        findBookById(id);
        newBook.setId(id);
        return repository.save(newBook);
    }

    private Book findBookById(Long id){
        return repository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro com id " + id + " não encontrado")
        );
    }
}
