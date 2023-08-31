package com.cartmicroservices.cartservice.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cartmicroservices.cartservice.DTO.CartItemDTO;
import com.cartmicroservices.cartservice.DTO.CartWithItemsResponseDTO;
import com.cartmicroservices.cartservice.DTO.CustomerDTO;
import com.cartmicroservices.cartservice.model.Cart;
import com.cartmicroservices.cartservice.model.CartItem;
import com.cartmicroservices.cartservice.model.Customer;
import com.cartmicroservices.cartservice.model.Product;
import com.cartmicroservices.cartservice.repository.CartItemRepository;
import com.cartmicroservices.cartservice.repository.CartRepository;
import com.cartmicroservices.cartservice.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CartItemServiceImpl implements CartItemService {

    CartItemRepository cartItemRepository;
    CartRepository cartRepository;
    CustomerRepository customerRepository;
    ProductServiceImpl productService;

    @Override
    public CartItem addItemsToCart(CartItem cartItem, Long customerId, Long productId) {
        Product product = productService.findProductById(productId);
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        Cart cart = cartRepository.findByCustomerId(customerId);

        if (cart == null) {
            cart = new Cart();
            cart.setCustomer(customer);
            cart.setCreationDate(cartItem.getCreationDate());
            cart = cartRepository.save(cart);
        }

        BigDecimal price = product.getPrice();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setName(product.getName());
        cartItem.setPrice(price);
        BigDecimal subTotal = price.multiply(BigDecimal.valueOf(cartItem.getQuantity()));
        cartItem.setSubTotal(subTotal);

        return cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteCartItem(long cartItemId, long cartId) {
        Optional<CartItem> optionalCartItem = cartItemRepository.findById(cartItemId);

        if (optionalCartItem.isPresent()) {
            CartItem cartItem = optionalCartItem.get();
            if (cartItem.getCart().getId() == cartId) {
                cartItemRepository.deleteById(cartItemId);
            } else {
                throw new IllegalArgumentException("El Item no pertenece al carrito.");
            }
        } else {
            throw new NoSuchElementException("No se encuentra el Item.");
        }
    }

    @Override
    public CartWithItemsResponseDTO getCartWithItemsByCustomer(Long customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId);
        List<CartItem> cartItems = cartItemRepository.findByCartId(cart.getId());

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(cart.getCustomer().getId());
        customerDTO.setName(cart.getCustomer().getName());

        List<CartItemDTO> cartItemDTOs = cartItems.stream()
                .map(cartItem -> {
                    CartItemDTO cartItemDTO = new CartItemDTO();
                    cartItemDTO.setId(cartItem.getId());
                    cartItemDTO.setName(cartItem.getName());
                    cartItemDTO.setPrice(cartItem.getPrice());
                    cartItemDTO.setQuantity(cartItem.getQuantity());
                    cartItemDTO.setSubTotal(cartItem.getSubTotal());
                    cartItemDTO.setCreationDate(cartItem.getCreationDate());
                    return cartItemDTO;
                })
                .collect(Collectors.toList());

        CartWithItemsResponseDTO responseDTO = new CartWithItemsResponseDTO();
        responseDTO.setCartId(cart.getId());
        responseDTO.setCustomer(customerDTO);
        responseDTO.setCartItems(cartItemDTOs);

        return responseDTO;
    }

}
