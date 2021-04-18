package com.example.springdataone.service;

import com.example.springdataone.repository.ProductRepository;
import com.example.springdataone.repository.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductManager {

    private ProductRepository productRepository;

    @Autowired
    public ProductManager(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    // GET all
    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    //GET by ID
    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    //POST
    public Product save(Product product){
        return productRepository.save(product);
    }

}
