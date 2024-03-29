package com.java.lms.service;


import com.java.lms.model.Person;
import com.java.lms.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MemberService {
    Role findPersonRole(String email);
    Person findByEmail(String email);
    Person findByUsername(String username);
    List<Person> findAll();
    Person save( Person person);
    void deleteById(Long id);
    boolean isPersonExist(Long id);
    Person findById(Long id);
}