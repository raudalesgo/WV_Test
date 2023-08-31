package com.productsmicroservices.productservice.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Hidden
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @NonNull
    @Column(name = "stock", nullable = false)
    private String stock;

    @NonNull
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @NonNull
    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @NonNull
    @Column(name = "modification_date", nullable = false)
    private LocalDate modificationDate;

    @NonNull
    @Column(name = "status", nullable = false)
    private Boolean status;

    
    @NonNull
    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Hidden
    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    
}
