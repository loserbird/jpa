package com.loserbird.springdata_mongodb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.query.Query.*;
import com.loserbird.springdata_mongodb.entity.Customer;
import com.loserbird.springdata_mongodb.entity.EmailAddress;

@Repository
@Profile("mongodb")
public class MongoDbCustomerRepository implements CustomerRepository{
	private final MongoOperations operations;

	
	@Autowired
	public MongoDbCustomerRepository(MongoOperations operations) {

		Assert.notNull(operations);
		this.operations = operations;
	}


	@Override
	public Customer findOne(Long id) {

		Query query = query(where("id").is(id));
		return operations.findOne(query, Customer.class);
	}

	
	@Override
	public Customer save(Customer customer) {

		operations.save(customer);
		return customer;
	}

	
	@Override
	public Customer findByEmailAddress(EmailAddress emailAddress) {

		Query query = query(where("emailAddress").is(emailAddress));
		return operations.findOne(query, Customer.class);
	}
}
