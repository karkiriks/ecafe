package com.edu.ecafe.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.ecafe.Domain.Person;
import com.edu.ecafe.Repository.PersonRepository;

@Service
@Transactional
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	@Transactional
	public void savePerson(Person person) {
		personRepository.save(person);
	}

}
