package com.java.lms.service;



import com.java.lms.model.Publisher;
import com.java.lms.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("publisherService")
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    @Transactional
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    @Transactional
    public Publisher findByName(String name) {
        return publisherRepository.findByName(name);
    }

    @Override
    @Transactional
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        publisherRepository.deleteById(id);
    }

    @Override
    public Publisher findById(Long id) {
        return publisherRepository.findById(id).get();
    }

}