package com.java.lms.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(scope = Person.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String title;
    private String year;
    private String isbn;
    @JsonProperty("available_books")
    private String availableBooks;

    @ManyToOne(cascade = CascadeType.ALL)
    private Publisher publisher;

    @NotNull
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> authors;


    @OneToOne(mappedBy = "book" ,fetch = FetchType.LAZY)
    private Transaction transactions;

    public List<Author> getAuthors()  {
        return authors;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(String availableBooks) {
        this.availableBooks = availableBooks;
    }

    public Long getId() {
        return id;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public String getTitle() {
        return title;
    }

    public Transaction getTransactions() {
        return transactions;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTransactions(Transaction transactions) {
        this.transactions = transactions;
    }

}