package com.example.springdataone;

import com.example.springdataone.repository.ProductRepository;
import com.example.springdataone.repository.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private ProductRepository productRepo;

    @Autowired
    public Start(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {
        Product p1 = new Product("Book", 29.99f, true);
        productRepo.save(p1);

        Product p2 = new Product("DVD Movie", 15.49f, true);
        productRepo.save(p2);

        Product p3 = new Product("CD Album", 44.99f, false);
        productRepo.save(p3);
    }
}
