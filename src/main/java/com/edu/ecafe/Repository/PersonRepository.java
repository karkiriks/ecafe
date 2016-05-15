package com.edu.ecafe.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.ecafe.Domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Serializable> {

}
