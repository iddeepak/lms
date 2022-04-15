package com.java.lms.repository;

import com.java.lms.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository("authorRepository")
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByName(String name);
}
