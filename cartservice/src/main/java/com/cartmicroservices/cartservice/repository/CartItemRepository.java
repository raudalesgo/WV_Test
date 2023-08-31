package com.cartmicroservices.cartservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cartmicroservices.cartservice.model.CartItem;

public interface CartItemRepository extends CrudRepository<CartItem,Long> {
    List<CartItem> findByCartId(Long cartId);
    
}
