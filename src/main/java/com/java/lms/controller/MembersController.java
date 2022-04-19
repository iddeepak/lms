package com.java.lms.controller;


import javax.validation.Valid;
import javax.validation.ValidationException;

import com.java.lms.dto.AuthorDTO;
import com.java.lms.dto.BookDTO;
import com.java.lms.dto.PersonDTO;
import com.java.lms.dto.PublisherDTO;
import com.java.lms.model.Book;
import com.java.lms.model.Person;
import com.java.lms.service.MemberService;
import com.java.lms.util.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class MembersController {
    @Autowired
    private MemberService memberService;


    @PostMapping("/addUser")
        public PersonDTO addUser(@Valid @RequestBody Person person)
                {
                    Person per= memberService.save(person);
                    return new PersonDTO(per.getId(),per.getName(),per.getEmail(),per.getExpiryDate(),per.getRole(),per.getPassword());

                }
    @PutMapping("/updateUser")
    public PersonDTO updateUser(@Valid @RequestBody Person person) {

        Person per =  memberService.save(person);
        return new PersonDTO(per.getId(),per.getName(),per.getEmail(),per.getExpiryDate(),per.getRole(),per.getPassword());

    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<ErrorMessage> deleteUser(@PathVariable Long id) throws ValidationException {
        Person b=memberService.findById(id);
        if(b!=null) {
            memberService.deleteById(id);
            return new ResponseEntity<ErrorMessage>(new ErrorMessage("200", "Ok"), HttpStatus.OK);
        }
        else {
            throw new ValidationException("Don't Exist");
        }
    }

    @GetMapping("/getUser/{id}")
    public PersonDTO getUser(@PathVariable Long id) throws ValidationException {
        Person temp=memberService.findById(id);
        PersonDTO per = new PersonDTO();
        per.setId(temp.getId());
        per.setName(temp.getName());
        per.setEmail(temp.getEmail());
        per.setExpiryDate(temp.getExpiryDate());
        per.setRole(temp.getRole());
        per.setPassword(temp.getPassword());

        return new PersonDTO(per.getId(),per.getName(),per.getEmail(),per.getExpiryDate(),per.getRole(),per.getPassword());


    }

}