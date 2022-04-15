package com.java.lms.repository;

import java.util.List;

import com.java.lms.model.Author;
import com.java.lms.model.Book;
import com.java.lms.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);

}
