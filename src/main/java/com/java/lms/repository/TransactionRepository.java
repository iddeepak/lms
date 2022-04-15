package com.java.lms.repository;

import java.util.List;

import com.java.lms.model.Book;
import com.java.lms.model.Person;
import com.java.lms.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("transactionRepository")
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Transaction findByBook(Book book);

    List<Transaction> findByPerson(Person person);

    List<Transaction> findByExpiryDate(String expiryDate);

}