package com.example.BookReview.models;

import lombok.*;

import java.time.LocalDate;

@Data
public class Review {
    private Long id;
    private Long nota;
    private String comentario;
    private LocalDate dataAvaliacao;
    private Book book;
}
