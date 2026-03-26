package com.example.BookReview.models;

import lombok.*;

import java.time.LocalDate;

@Data
public class Book {

    private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private LocalDate anoPubçlicacao;



}
