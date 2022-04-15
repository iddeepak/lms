package com.java.lms.service;

import com.java.lms.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    List<Author> findAll();

    Author findByName(String name);

    Author save(Author author);

    Author findById(Long id);

    void deleteById(Long id);

}