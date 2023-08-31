package com.cartmicroservices.cartservice.service;

import com.cartmicroservices.cartservice.DTO.CartWithItemsResponseDTO;
import com.cartmicroservices.cartservice.model.CartItem;

public interface CartItemService {
    CartWithItemsResponseDTO getCartWithItemsByCustomer(Long customerId);
    CartItem addItemsToCart(CartItem cartItem,Long customerId, Long productId);
    void deleteCartItem(long cartItemId, long cartId);
}
