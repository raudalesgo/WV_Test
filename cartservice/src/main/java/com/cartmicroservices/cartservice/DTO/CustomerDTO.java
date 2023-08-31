package com.cartmicroservices.cartservice.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO {
    @NonNull
    private Long id;
    @NonNull
    private String name;
}
