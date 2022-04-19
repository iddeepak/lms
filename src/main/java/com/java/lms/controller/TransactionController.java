package com.java.lms.controller;


import java.util.ArrayList;

import javax.validation.Valid;

import com.java.lms.dto.*;
import com.java.lms.model.Transaction;
import com.java.lms.service.BookService;
import com.java.lms.service.MemberService;
import com.java.lms.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private BookService bookService;
    @Autowired
    private MemberService memberService;


    @PostMapping("/transaction")
    public TransactionDTO addTransaction(@Valid @RequestBody Transaction transaction) {
        Transaction temp = transactionService.save(transaction);
        PersonDTO person = new PersonDTO(temp.getPerson().getId(), temp.getPerson().getName(),
                temp.getPerson().getEmail(),
                temp.getPerson().getExpiryDate());
        PublisherDTO pub = new PublisherDTO(temp.getBook().getPublisher().getId(),
                temp.getBook().getPublisher().getName());

        ArrayList<AuthorDTO> auths = new ArrayList<>();
        AuthorDTO auth;
        for (int i = 0; i < temp.getBook().getAuthors().size(); i++) {
            auth = new AuthorDTO(temp.getBook().getAuthors().get(i).getId(),
                    temp.getBook().getAuthors().get(i).getName());
            auths.add(auth);
        }
        BookDTO book = new BookDTO(temp.getId(), temp.getBook().getTitle(), temp.getBook().getYear() , temp.getBook().getIsbn()
                , temp.getBook().getAvailableBooks() , pub , auths);
        TransactionDTO trans = new TransactionDTO(temp.getId(), temp.getIssueDate(), temp.getExpiryDate(), person,
                book);
        return trans;

    }


}