package com.java.lms.repository;

import com.java.lms.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("publisherRepository")
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Publisher findByName(String name);
}
