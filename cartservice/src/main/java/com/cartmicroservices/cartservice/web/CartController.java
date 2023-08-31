package com.cartmicroservices.cartservice.web;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cartmicroservices.cartservice.DTO.CartWithItemsResponseDTO;
import com.cartmicroservices.cartservice.model.CartItem;
import com.cartmicroservices.cartservice.model.Customer;
import com.cartmicroservices.cartservice.model.Product;
import com.cartmicroservices.cartservice.service.CartItemService;
import com.cartmicroservices.cartservice.service.CartService;
import com.cartmicroservices.cartservice.service.CustomerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/cart")
public class CartController {
    CartService cartServicervice;
    CartItemService cartItemService;
    RestTemplate restTemplate;
    CustomerService  customerService;
    


    @GetMapping("/customer/{customerId}")
    public ResponseEntity<CartWithItemsResponseDTO> getCartByCustomer(@PathVariable Long customerId) {
        CartWithItemsResponseDTO responseDTO = cartItemService.getCartWithItemsByCustomer(customerId);
        return new  ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @PostMapping("/customer/{customerId}/product/{productId}")
    public ResponseEntity<CartItem> addCartItems(@RequestBody CartItem cartItem, @PathVariable Long productId, @PathVariable Long customerId){
        return new ResponseEntity<>(cartItemService.addItemsToCart(cartItem,customerId,productId ),HttpStatus.CREATED);

    }

    @DeleteMapping("/{cartId}/cartItem/{cartItemId}")
    public ResponseEntity<HttpStatus> deleteItem(@PathVariable Long cartItemId, @PathVariable Long cartId){
        cartItemService.deleteCartItem(cartItemId,cartId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getRemoteProducts() {
        String url = "http://localhost:8081/all"; 
        ResponseEntity<List<Product>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {});
        return response;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<>(customerService.getCustomers(),HttpStatus.CREATED);
    }

}

