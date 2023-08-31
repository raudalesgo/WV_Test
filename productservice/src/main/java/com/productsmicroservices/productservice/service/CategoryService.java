package com.productsmicroservices.productservice.service;

import java.util.List;

import com.productsmicroservices.productservice.model.Category;


public interface CategoryService {

    List<Category> getCategories();
    Category saveCategory(Category category);

    
}
