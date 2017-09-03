package com.loserbird.springdata_mongodb;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.loserbird.springdata_mongodb.dao.ProductRepository;
import com.loserbird.springdata_mongodb.entity.Product;

public class ProductRepositoryIntegrationTest extends AbstractIntegrationTest {
	@Autowired
	ProductRepository repository;

	@Test
	public void createProduct() {

		Product product = new Product("Camera bag", new BigDecimal(49.99));
		product = repository.save(product);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void lookupProductsByDescription() {

		Pageable pageable = new PageRequest(0, 1, Direction.DESC, "name");
		Page<Product> page = repository.findByDescriptionContaining("Apple", pageable);
		
	}
}
