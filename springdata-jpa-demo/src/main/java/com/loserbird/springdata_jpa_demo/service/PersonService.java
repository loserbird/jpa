package com.loserbird.springdata_jpa_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loserbird.springdata_jpa_demo.entity.Person;
import com.loserbird.springdata_jpa_demo.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepsotory;
	
	@Transactional
	public void savePersons(List<Person> persons){
		personRepsotory.save(persons);
	}
	
	@Transactional
	public void updatePersonEmail(String email, Integer id){
		personRepsotory.updatePersonEmail(id, email);
	}

}
