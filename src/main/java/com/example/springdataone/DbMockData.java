package com.example.springdataone;

import com.example.springdataone.repository.CustomerRepository;
import com.example.springdataone.repository.OrderRepository;
import com.example.springdataone.repository.ProductRepository;
import com.example.springdataone.repository.entity.Customer;
import com.example.springdataone.repository.entity.Order;
import com.example.springdataone.repository.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class DbMockData {
    private ProductRepository productRepository;
    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public DbMockData(ProductRepository productRepository, OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fill() {
        Product product = new Product("Book", 29.99f, true);
        Product product1 = new Product("DVD Movie", 15.49f, true);
        Customer customer = new Customer("Jak Kowalski", "Wrocław");
        Set<Product> products = new HashSet<>() {
            {
                add(product);
                add(product1);
            }};
        Order order = new Order(customer, products, LocalDateTime.now(), "in progress");

        productRepository.save(product);
        productRepository.save(product1);
        customerRepository.save(customer);
        orderRepository.save(order);

        Product product2 = new Product("CD Album", 44.99f, true);
        Product product3 = new Product("Book", 29.99f, true);
        Product product4 = new Product("Other Book", 24.99f, true);
        Customer customer1 = new Customer("Anna Nowak", "Warszawa");
        Set<Product> products1 = new HashSet<>() {
            {
                add(product2);
                add(product3);
                add(product4);
            }};
        Order order1 = new Order(customer1, products1, LocalDateTime.now(), "in progress");

        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        customerRepository.save(customer1);
        orderRepository.save(order1);
    }
}