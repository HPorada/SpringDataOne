package com.example.springdataone.service;

import com.example.springdataone.repository.CustomerRepository;
import com.example.springdataone.repository.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerManager {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    // GET all
    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    }

    //GET by ID
    public Optional<Customer> findById(Long id){
        return customerRepository.findById(id);
    }

    //POST
    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

}
