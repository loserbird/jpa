package com.loserbird.springdata_jpa_demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.loserbird.springdata_jpa_demo.entity.Person;

public class PersonRepositoryImpl implements PersonDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void test() {
		Person person = entityManager.find(Person.class, 11);
		System.out.println("-->" + person);
	}
}
