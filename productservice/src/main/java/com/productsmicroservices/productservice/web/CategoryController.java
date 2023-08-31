package com.productsmicroservices.productservice.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productsmicroservices.productservice.model.Category;
import com.productsmicroservices.productservice.service.CategoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController("/category")
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategoryById() {
        List<Category> category = categoryService.getCategories();
        return new ResponseEntity<>(category,HttpStatus.OK);

    }

    @PostMapping("/register")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.saveCategory(category),HttpStatus.CREATED);
    }



    
}
