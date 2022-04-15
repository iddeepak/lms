package com.java.lms.service;

import com.java.lms.model.Publisher;

import java.util.List;


public interface PublisherService {

    List<Publisher> findAll();

    Publisher findByName(String name);

    Publisher save( Publisher publisher);

    void deleteById(Long id);

    Publisher findById(Long id);

}