package com.loserbird.springdata_mongodb.entity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.util.Assert;

public class Order extends AbstractDocument{
	@DBRef
	private Customer customer;
	private Address billingAddress;
	private Address shippingAddress;
	private Set<LineItem> lineItems = new HashSet<LineItem>();

	
	public Order(Customer customer, Address shippingAddress) {
		this(customer, shippingAddress, null);
	}

	
	@PersistenceConstructor
	public Order(Customer customer, Address shippingAddress, Address billingAddress) {

		Assert.notNull(customer);
		Assert.notNull(shippingAddress);

		this.customer = customer;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
	}

	
	public void add(LineItem lineItem) {
		this.lineItems.add(lineItem);
	}

	
	public Customer getCustomer() {
		return customer;
	}


	public Address getBillingAddress() {
		return billingAddress != null ? billingAddress : shippingAddress;
	}

	
	public Address getShippingAddress() {
		return shippingAddress;
	}

	
	public Set<LineItem> getLineItems() {
		return Collections.unmodifiableSet(lineItems);
	}

	
	public BigDecimal getTotal() {

		BigDecimal total = BigDecimal.ZERO;

		for (LineItem item : lineItems) {
			total = total.add(item.getTotal());
		}

		return total;
	}
}
