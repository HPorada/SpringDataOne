package com.example.springdataone.service;

import com.example.springdataone.repository.OrderRepository;
import com.example.springdataone.repository.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderManager {

    private OrderRepository orderRepository;

    @Autowired
    public OrderManager(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    // GET all
    public Iterable<Order> findAll(){
        return orderRepository.findAll();
    }

    //GET by ID
    public Optional<Order> findById(Long id){
        return orderRepository.findById(id);
    }

    //POST
    public Order save(Order order){
        return orderRepository.save(order);
    }

}
