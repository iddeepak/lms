package com.java.lms.service;


import com.java.lms.model.Person;
import com.java.lms.model.Role;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    Role findPersonRole(String email);
    Person findByEmail(String email);
    List<Person> findAll();
    Optional<Person> findByID(Long id);
    Person save( Person person);
    void deleteById(Long id);
    boolean isPersonExist(Long id);
}