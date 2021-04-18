package com.example.springdataone.controller;

import com.example.springdataone.repository.entity.Customer;
import com.example.springdataone.service.CustomerManager;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping
public class CustomerApi {

    private CustomerManager customers;

    @Autowired
    public CustomerApi(CustomerManager customers) {
        this.customers = customers;
    }

    @GetMapping("/api/customer/all")
    public Iterable<Customer> getAll() {
        return customers.findAll();
    }

    @GetMapping("/api/customer")
    public Optional<Customer> getByID(@RequestParam Long id) {
        return customers.findById(id);
    }

    @PostMapping("api/admin/customer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customers.save(customer);
    }

    @PutMapping("api/admin/customer")
    public Customer updateCustomer(@RequestParam Long id, @RequestBody Customer customer) {
        customer.setId(id);

        return customers.save(customer);
    }

    @PatchMapping("api/admin/customer")
    public Customer patchUpdateCustomer(@RequestParam Long id, @RequestBody Customer customer) {
        String name = customer.getName();
        String address = customer.getAddress();

        Optional<Customer> old = customers.findById(id);
        String oldName = old.get().getName();
        String oldAddress = old.get().getAddress();

        if (name == null) {
            customer.setName(oldName);
        }
        if (address == null) {
            customer.setAddress(oldAddress);
        }

        return customers.save(customer);
    }
}
