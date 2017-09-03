package com.loserbird.springdata_mongodb.dao;

import org.springframework.data.repository.Repository;

import com.loserbird.springdata_mongodb.entity.Customer;
import com.loserbird.springdata_mongodb.entity.EmailAddress;

public interface CustomerRepository extends Repository<Customer, Long> {
	Customer findOne(Long id);
	Customer save(Customer customer);
	Customer findByEmailAddress(EmailAddress emailAddress);
}
