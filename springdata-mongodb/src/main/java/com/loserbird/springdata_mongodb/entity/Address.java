package com.loserbird.springdata_mongodb.entity;

import org.springframework.util.Assert;

public class Address {
	private final String street, city, country;

	
	public Address(String street, String city, String country) {

		Assert.hasText(street, "Street must not be null or empty!");
		Assert.hasText(city, "City must not be null or empty!");
		Assert.hasText(country, "Country must not be null or empty!");

		this.street = street;
		this.city = city;
		this.country = country;
	}

	
	public Address getCopy() {
		return new Address(this.street, this.city, this.country);
	}

	
	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	
	public String getCountry() {
		return country;
	}
}
