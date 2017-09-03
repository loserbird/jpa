package com.loserbird.springdata_mongodb.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.loserbird.springdata_mongodb.entity.Customer;
import com.loserbird.springdata_mongodb.entity.Order;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long>{
	List<Order> findByCustomer(Customer customer);
}
