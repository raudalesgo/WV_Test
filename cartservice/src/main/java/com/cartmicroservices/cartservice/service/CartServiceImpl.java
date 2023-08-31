package com.cartmicroservices.cartservice.service;

import org.springframework.stereotype.Service;

import com.cartmicroservices.cartservice.model.Cart;
import com.cartmicroservices.cartservice.repository.CartRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CartServiceImpl implements CartService{

    CartRepository cartRepository;


    @Override
    public Cart getCartByCustomerId(Long customerid) {
        return  cartRepository.findByCustomerId(customerid);
    }

    @Override
    public  Cart addCart(Cart cart) {
        return cartRepository.save(cart);
        
    }
    
}
