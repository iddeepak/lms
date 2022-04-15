package com.java.lms.service;


import com.java.lms.model.Book;
import com.java.lms.model.Person;
import com.java.lms.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {

    Transaction save(Transaction transaction);

    Transaction findById(Long id);

    Transaction findByBook(Book book);

    List<Transaction> findByPerson(Person personTemp);

    void deleteById(Long id);

    List<Transaction> findAll();

    void delete(Transaction transc);

    List<Transaction> findByExpiryDate(String expiryDate);

}