package com.loserbird.spring_hibernate_jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loserbird.spring_hibernate_jpa.dao.PersonDao;
import com.loserbird.spring_hibernate_jpa.entity.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	@Transactional
	public void savePersons(Person p1, Person p2){
		personDao.save(p1);
		//抛出异常事务回滚
		int i = 10 / 0;
		
		personDao.save(p2);
	}
	
}
