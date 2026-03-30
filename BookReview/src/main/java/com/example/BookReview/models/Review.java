package com.example.BookReview.models;

import lombok.*;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer nota;
    private String comentario;
    private LocalDate dataAvaliacao;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
