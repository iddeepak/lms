package com.java.lms.service;


import com.java.lms.model.Author;
import com.java.lms.model.Book;
import com.java.lms.model.Publisher;
import jdk.jfr.Category;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public interface BookService {

    Book save(@Valid Book book);

    List<Book> findAll();

    List<Book> findByTitle(String title);


    Book findById(Long id);

    void deleteById(Long id);

}