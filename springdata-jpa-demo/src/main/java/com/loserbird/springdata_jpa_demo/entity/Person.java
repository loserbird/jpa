package com.loserbird.springdata_jpa_demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * created by bingqin on 2017年9月2日
 * @description
 *
 */
@Table(name="jpa_persons")
@Entity
public class Person {
	private Integer id;
	private String lastName;

	private String email;
	private Date birth;
	
	private Address address;
	
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	
	@JoinColumn(name="ADDRESS_ID")
	@ManyToOne
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", lastName=" + lastName + ", email="
				+ email + ", brith=" + birth + "]";
	}
}
