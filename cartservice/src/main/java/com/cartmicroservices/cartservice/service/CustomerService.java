package com.cartmicroservices.cartservice.service;

import java.util.List;

import com.cartmicroservices.cartservice.model.Customer;

public interface CustomerService {
    List<Customer> getCustomers();
    
}
