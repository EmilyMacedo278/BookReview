package com.example.BookReview.controllers;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookReview.models.Book;
import com.example.BookReview.services.BookService;

@RestController
@RequestMapping("book")
@Slf4j
public class BookControllers {
    @Autowired
    private BookService service;

    @GetMapping
    public List<Book> listAll(){
        return service.getAllBook();
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(service.addBook(book));
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        log.info("Obtendo dados do livro{]", id);
        return ResponseEntity.ok(service.getBookById(id));
    }

    @DeleteMapping("/{id}")
public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    log.info("Deletando livro com id {}", id);
    service.deleteBook(id);
    return ResponseEntity.noContent().build();
}


    @PutMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
        log.info("Atualizando livro com id {} com os dados {]", id, book);
        return ResponseEntity.ok( service.updateBook(id, book) );
}

}