package com.cartmicroservices.cartservice.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cartmicroservices.cartservice.model.Product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductServiceImpl {

    RestTemplate restTemplate;

    public List<Product> getRemoteProducts() {
        String url = "http://localhost:8081/all"; 
        ResponseEntity<List<Product>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {});
        return response.getBody();
    }


    public Product findProductById(Long productId) {
        List<Product> remoteProducts = getRemoteProducts();
        
        return remoteProducts.stream()
            .filter(product -> product.getId().equals(productId))
            .findFirst() 
            .orElse(null); 
    }
    
}
