package com.cartmicroservices.cartservice.DTO;



import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartWithItemsResponseDTO {
    
    @NonNull
    private Long cartId;
    @NonNull
    private CustomerDTO customer;
    @NonNull
    private List<CartItemDTO> cartItems;


}

