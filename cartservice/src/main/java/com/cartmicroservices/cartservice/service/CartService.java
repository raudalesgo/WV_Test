package com.cartmicroservices.cartservice.service;

import com.cartmicroservices.cartservice.model.Cart;

public interface CartService {
    Cart getCartByCustomerId(Long id);
    Cart addCart(Cart cart);


}
