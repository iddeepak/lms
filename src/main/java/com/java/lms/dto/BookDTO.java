package com.java.lms.dto;

import java.util.ArrayList;

public class BookDTO {
    private Long id;
    private String title;
    private String year;
    private String isbn;
    private String availableBooks;

    private PublisherDTO publisher;

    private ArrayList<AuthorDTO> authors;

    public BookDTO() {

    }

    public BookDTO(Long id, String title, PublisherDTO publisher, ArrayList<AuthorDTO> authors) {

        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.authors = authors;
    }


    public ArrayList<AuthorDTO> getAuthors() {
        return authors;
    }

    public Long getId() {
        return id;
    }

    public PublisherDTO getPublisher() {
        return publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthors(ArrayList<AuthorDTO> authors) {
        this.authors = authors;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPublisher(PublisherDTO publisher) {
        this.publisher = publisher;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
