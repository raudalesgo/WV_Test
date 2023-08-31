package com.productsmicroservices.productservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.productsmicroservices.productservice.model.Category;

public interface CategoryRepository extends CrudRepository<Category,Long> {
    
}
