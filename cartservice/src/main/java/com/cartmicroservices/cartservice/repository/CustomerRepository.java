package com.cartmicroservices.cartservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.cartmicroservices.cartservice.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
    
}
