package com.loserbird.springdata_mongodb.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import com.loserbird.springdata_mongodb.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	Page<Product> findByDescriptionContaining(String description, Pageable pageable);
}
