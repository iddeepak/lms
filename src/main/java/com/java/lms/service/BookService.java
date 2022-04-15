package com.java.lms.service;


import com.java.lms.model.Author;
import com.java.lms.model.Book;
import com.java.lms.model.Publisher;
import jdk.jfr.Category;

import javax.validation.Valid;
import java.util.List;


public interface BookService {

    Book save(@Valid Book book);

    List<Book> findAll();

    List<Book> findByTitle(String title);

    List<Book> findByPublisher(Publisher pub);

    List<Book> findByAuthors(List<Author> auths);

    Book findById(Long id);

    void deleteById(Long id);

}