package com.cartmicroservices.cartservice.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartItemDTO {
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private BigDecimal price;
    @NonNull
    private Long quantity;
    @NonNull
    private BigDecimal subTotal;
    @NonNull
    private LocalDate creationDate;
}