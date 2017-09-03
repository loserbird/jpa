package com.loserbird.springdata_mongodb.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.util.Assert;

public class Customer extends AbstractDocument{
	private String firstname, lastname;

	@Field("email")
	@Indexed(unique = true)
	private EmailAddress emailAddress;
	private Set<Address> addresses = new HashSet<Address>();

	
	public Customer(String firstname, String lastname) {

		Assert.hasText(firstname);
		Assert.hasText(lastname);

		this.firstname = firstname;
		this.lastname = lastname;
	}

	protected Customer() {

	}


	public void add(Address address) {

		Assert.notNull(address);
		this.addresses.add(address);
	}

	
	public String getFirstname() {
		return firstname;
	}


	public String getLastname() {
		return lastname;
	}

	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public EmailAddress getEmailAddress() {
		return emailAddress;
	}

	
	public void setEmailAddress(EmailAddress emailAddress) {
		this.emailAddress = emailAddress;
	}


	public Set<Address> getAddresses() {
		return Collections.unmodifiableSet(addresses);
	}
}
