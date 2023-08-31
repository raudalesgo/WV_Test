package com.cartmicroservices.cartservice.repository;



import org.springframework.data.repository.CrudRepository;

import com.cartmicroservices.cartservice.model.Cart;

public interface CartRepository extends CrudRepository<Cart,Long> {

        Cart findByCustomerId(Long customerId);
}
