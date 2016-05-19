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

	
	public PersonService(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}

	public PersonService() {

	}
	@Transactional
	public void savePerson(Person person) {
		personRepository.save(person);
	}
	@Transactional
	public Person findByUserName(String username){
		return personRepository.findByUsername(username);
	}
	@Transactional
	public Person findById(Long id){
		return personRepository.findById(id);
	}
	
	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	
	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

}
