package com.cartmicroservices.cartservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cartmicroservices.cartservice.model.Customer;
import com.cartmicroservices.cartservice.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService{
    CustomerRepository  customerRepository;

    @Override
    public List<Customer> getCustomers() {
       return (List<Customer>) customerRepository.findAll();
    }
    
}
