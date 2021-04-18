package com.example.springdataone.controller;

import com.example.springdataone.repository.entity.Customer;
import com.example.springdataone.repository.entity.Order;
import com.example.springdataone.repository.entity.Product;
import com.example.springdataone.service.OrderManager;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping
public class OrderApi {

    private OrderManager orders;

    @Autowired
    public OrderApi(OrderManager orders) {
        this.orders = orders;
    }

    @GetMapping("/api/order/all")
    public Iterable<Order> getAll() {
        return orders.findAll();
    }

    @GetMapping("/api/order")
    public Optional<Order> getByID(@RequestParam Long id) {
        return orders.findById(id);
    }

    @PostMapping("api/admin/order")
    public Order addOrder(@RequestBody Order order) {
        return orders.save(order);
    }

    @PutMapping("api/admin/order")
    public Order updateOrder(@RequestParam Long id, @RequestBody Order order) {
        order.setId(id);

        return orders.save(order);
    }

    @PatchMapping("api/admin/order")
    public Order patchUpdateOrder(@RequestParam Long id, @RequestBody Order order) {
        Customer customer = order.getCustomer();
        Set<Product> products = order.getProducts();
        LocalDateTime placeDate = order.getPlaceDate();
        String status = order.getStatus();

        Optional<Order> old = orders.findById(id);
        Customer oldCustomer = old.get().getCustomer();
        Set<Product> oldProducts = old.get().getProducts();
        LocalDateTime oldPlaceDate = old.get().getPlaceDate();
        String oldStatus = old.get().getStatus();

        if (customer == null) {
            order.setCustomer(oldCustomer);
        }
        if (products == null) {
            order.setProducts(oldProducts);
        }
        if(placeDate == null){
            order.setPlaceDate(oldPlaceDate);
        }
        if(status == null){
            order.setStatus(oldStatus);
        }

        return orders.save(order);
    }
}
