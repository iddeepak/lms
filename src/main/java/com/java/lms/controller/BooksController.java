package com.java.lms.controller;

import com.java.lms.dto.AuthorDTO;
import com.java.lms.dto.BookDTO;
import com.java.lms.dto.PublisherDTO;
import com.java.lms.model.Book;
import com.java.lms.service.AuthorService;
import com.java.lms.service.BookService;
import com.java.lms.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;


@RestController
@RequestMapping("/api")
public class BooksController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private PublisherService publisherService;

    @PostMapping("/addBook")
    public BookDTO addBook(@Valid @RequestBody Book book) {
        Book temp =  bookService.save(book);

        ArrayList<AuthorDTO> auths = new ArrayList<>();
        AuthorDTO autt;
        PublisherDTO pub;

        for (int k = 0; k < temp.getAuthors().size(); k++) {
            autt = new AuthorDTO(temp.getAuthors().get(k).getId(), temp.getAuthors().get(k).getName());
            auths.add(autt);
        }
        pub = new PublisherDTO(temp.getPublisher().getId(), temp.getPublisher().getName());

        return new BookDTO(temp.getId(), temp.getTitle(), pub, auths);


    }
}
