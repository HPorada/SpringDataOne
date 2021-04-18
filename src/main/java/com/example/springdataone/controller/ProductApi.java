package com.example.springdataone.controller;

import com.example.springdataone.repository.entity.Product;
import com.example.springdataone.service.ProductManager;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping
public class ProductApi {

    private ProductManager products;

    @Autowired
    public ProductApi(ProductManager products) {
        this.products = products;
    }

    @GetMapping("/api/product/all")
    public Iterable<Product> getAll() {
        return products.findAll();
    }

    @GetMapping("/api/product")
    public Optional<Product> getByID(@RequestParam Long id) {
        return products.findById(id);
    }

    @PostMapping("api/admin/product")
    public Product addProduct(@RequestBody Product product) {
        return products.save(product);
    }

    @PutMapping("api/admin/product")
    public Product updateProduct(@RequestParam Long id, @RequestBody Product product) {
        return products.save(product);
    }

    @PatchMapping("api/admin/product")
    public Product patchUpdateProduct(@RequestParam Long id, @RequestBody Product product) {
        String name = product.getName();
        float price = product.getPrice();
        boolean available = product.isAvailable();

        Optional<Product> old = products.findById(id);
        String oldName = old.get().getName();
        float oldPrice = old.get().getPrice();
        boolean oldAvailable = old.get().isAvailable();

        if (name == null) {
            product.setName(oldName);
        }
        if (price == 0) {
            product.setPrice(oldPrice);
        }
        if(available == false && oldAvailable == true){
            product.setAvailable(false);
        }

        return products.save(product);
    }
}
