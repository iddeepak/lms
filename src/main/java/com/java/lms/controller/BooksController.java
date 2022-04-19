package com.java.lms.controller;

import com.java.lms.dto.AuthorDTO;
import com.java.lms.dto.BookDTO;
import com.java.lms.dto.PublisherDTO;
import com.java.lms.model.Book;
import com.java.lms.service.AuthorService;
import com.java.lms.service.BookService;
import com.java.lms.service.PublisherService;
import com.java.lms.util.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
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

        return new BookDTO(temp.getId(), temp.getTitle(), temp.getYear() , temp.getIsbn() , temp.getAvailableBooks() , pub, auths);


    }

    @PutMapping("/updateBook")
    public BookDTO updateBook(@Valid @RequestBody Book book) {

        Book temp =  bookService.save(book);
        ArrayList<AuthorDTO> auths = new ArrayList<>();
        AuthorDTO autt;
        PublisherDTO pub;

        for (int k = 0; k < temp.getAuthors().size(); k++) {
            autt = new AuthorDTO(temp.getAuthors().get(k).getId(), temp.getAuthors().get(k).getName());
            auths.add(autt);
        }
        pub = new PublisherDTO(temp.getPublisher().getId(), temp.getPublisher().getName());

        return new BookDTO(temp.getId(), temp.getTitle(), temp.getYear() , temp.getIsbn() , temp.getAvailableBooks() , pub, auths);

    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<ErrorMessage> deleteBook(@PathVariable Long id) throws ValidationException {
        Book b=bookService.findById(id);
        if(b!=null) {
            bookService.deleteById(id);
            return new ResponseEntity<ErrorMessage>(new ErrorMessage("200", "Ok"), HttpStatus.OK);
        }
        else {
            throw new ValidationException("Don't Exist");
        }


    }
    @GetMapping("/getBook/{id}")
    public BookDTO getBook(@PathVariable Long id) throws ValidationException {
        Book temp=bookService.findById(id);

        ArrayList<AuthorDTO> auths = new ArrayList<>();
        AuthorDTO autt;
        PublisherDTO pub;

        for (int k = 0; k < temp.getAuthors().size(); k++) {
            autt = new AuthorDTO(temp.getAuthors().get(k).getId(), temp.getAuthors().get(k).getName());
            auths.add(autt);
        }
        pub = new PublisherDTO(temp.getPublisher().getId(), temp.getPublisher().getName());

        return new BookDTO(temp.getId(), temp.getTitle(), temp.getYear() , temp.getIsbn() , temp.getAvailableBooks() , pub, auths);


    }
}
