package com.loserbird.springdata_mongodb;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ActiveProfiles;

import com.loserbird.springdata_mongodb.dao.CustomerRepository;
import com.loserbird.springdata_mongodb.entity.Address;
import com.loserbird.springdata_mongodb.entity.Customer;
import com.loserbird.springdata_mongodb.entity.EmailAddress;

@ActiveProfiles("mongodb")
public class MongoDbCustomerRepositoryIntegrationTest extends AbstractIntegrationTest{
	@Configuration
	@ComponentScan(basePackageClasses = TestConfiguration.class)
	static class TestConfiguration {

	}

	@Autowired
	@Qualifier("mongoDbCustomerRepository")
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
	}

	@Test(expected = DuplicateKeyException.class)
	public void preventsDuplicateEmail() {

		Customer dave = repository.findByEmailAddress(new EmailAddress("dave@dmband.com"));

		Customer anotherDave = new Customer("Dave", "Matthews");
		anotherDave.setEmailAddress(dave.getEmailAddress());

		repository.save(anotherDave);
	}
}
