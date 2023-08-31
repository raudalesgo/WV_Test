package com.productsmicroservices.productservice.service;

import java.util.List;
import com.productsmicroservices.productservice.model.Product;

public interface ProductService {
    Product getProduct(Long id);
    List<Product> getProducts();
    Product saveProduct(Product product, Long id);
    Product updateProduct(Product product,long id);
    void deleteProduct(long id);

    
}
