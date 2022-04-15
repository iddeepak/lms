package com.java.lms.repository;

import com.java.lms.model.Person;
import com.java.lms.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository("memberRepository")
public interface MemberRepository extends JpaRepository<Person, Long> {
    Person findByEmailAndPassword(String email,String password);
    Person findByEmail(String email);
    @Query("select p.role from Person p WHERE p.email=:email")
    Role findPersonRole(@Param("email") String email);
}
