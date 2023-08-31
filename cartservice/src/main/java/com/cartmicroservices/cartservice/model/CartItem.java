package com.cartmicroservices.cartservice.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_item")
public class CartItem {
  
    @Hidden
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @Hidden
    @NonNull
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Schema(example = "2")
    @NonNull
    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Hidden
    @NonNull
    @Column(name = "sub_total", nullable = false)
    private BigDecimal subTotal;

    @Schema(example = "2023-08-31")
    @NonNull
    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Hidden
    @ManyToOne(optional = false)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    @Hidden
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    
}
