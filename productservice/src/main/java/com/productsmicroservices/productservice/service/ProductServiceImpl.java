package com.productsmicroservices.productservice.service;

import java.util.List;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;

import com.productsmicroservices.productservice.model.Category;
import com.productsmicroservices.productservice.model.Product;
import com.productsmicroservices.productservice.repository.CategoryRepository;
import com.productsmicroservices.productservice.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    
    }

    @Override
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product, Long categoryId) {
       Category category = categoryRepository.findById(categoryId).get();
       product.setCategory(category);
       return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product, long id) {
     Product validProduct = productRepository.findById(id).orElseThrow(
        () -> new EntityNotFoundException("Producto no encontrado: " + id));
        
     Field[] fields = Product.class.getDeclaredFields();
     for (Field field : fields) {
         field.setAccessible(true);
         try {
             Object newValue = field.get(product);
             if (newValue != null) {
                 field.set(validProduct, newValue);
             }
         } catch (IllegalAccessException e) {
            throw new RuntimeException("Error al actualizar el producto", e);
         }
     }

     return productRepository.save(validProduct);
    }

    @Override
    public void deleteProduct(long id) {
         productRepository.deleteById(id);
    }
    
}
