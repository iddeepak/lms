package com.java.lms.service;

import com.java.lms.model.Publisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PublisherService {

    List<Publisher> findAll();

    Publisher findByName(String name);

    Publisher save( Publisher publisher);

    void deleteById(Long id);

    Publisher findById(Long id);

}