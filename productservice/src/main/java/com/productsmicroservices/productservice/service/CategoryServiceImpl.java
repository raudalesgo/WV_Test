package com.productsmicroservices.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productsmicroservices.productservice.model.Category;
import com.productsmicroservices.productservice.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRep;

    @Override
    public List<Category> getCategories() {
        return (List<Category>)categoryRep.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRep.save(category);
    }


}
