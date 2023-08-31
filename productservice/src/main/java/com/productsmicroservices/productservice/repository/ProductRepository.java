package com.productsmicroservices.productservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.productsmicroservices.productservice.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
