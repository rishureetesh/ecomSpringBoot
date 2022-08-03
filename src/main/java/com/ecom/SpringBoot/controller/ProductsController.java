package com.ecom.SpringBoot.controller;

import com.ecom.SpringBoot.model.Product;
import com.ecom.SpringBoot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;
    @GetMapping
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @PostMapping
    public Product addProducts(@RequestBody Product productDetails){
        return productRepository.save((productDetails));
    }
}
