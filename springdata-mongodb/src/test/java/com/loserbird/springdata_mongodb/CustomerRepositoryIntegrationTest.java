package com.loserbird.springdata_mongodb;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import com.loserbird.springdata_mongodb.dao.CustomerRepository;
import com.loserbird.springdata_mongodb.entity.Address;
import com.loserbird.springdata_mongodb.entity.Customer;
import com.loserbird.springdata_mongodb.entity.EmailAddress;

public class CustomerRepositoryIntegrationTest extends AbstractIntegrationTest{
	@Autowired
	CustomerRepository repository;

	@Test
	public void savesCustomerCorrectly() {

		EmailAddress email = new EmailAddress("alicia@keys.com");

		Customer dave = new Customer("Alicia", "Keys");
		dave.setEmailAddress(email);
		dave.add(new Address("27 Broadway", "New York", "United States"));

		Customer result = repository.save(dave);
	}

	@Test
	public void readsCustomerByEmail() {

		EmailAddress email = new EmailAddress("alicia@keys.com");
		Customer alicia = new Customer("Alicia", "Keys");
		alicia.setEmailAddress(email);

		repository.save(alicia);

		Customer result = repository.findByEmailAddress(email);
		System.out.println(result.getEmailAddress());
	}

	@Test(expected = DuplicateKeyException.class)
	public void preventsDuplicateEmail() {

		Customer dave = repository.findByEmailAddress(new EmailAddress("dave@dmband.com"));

		Customer anotherDave = new Customer("Dave", "Matthews");
		anotherDave.setEmailAddress(dave.getEmailAddress());

		repository.save(anotherDave);
	}
}
