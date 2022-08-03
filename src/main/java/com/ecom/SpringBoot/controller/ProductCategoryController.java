package com.ecom.SpringBoot.controller;

import com.ecom.SpringBoot.model.ProductCategory;
import com.ecom.SpringBoot.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/category")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @GetMapping
    public List<ProductCategory> getProductCategories(){
        return productCategoryRepository.findAll();
    }

    @PostMapping
    public ProductCategory addProductCategory(@RequestBody ProductCategory productCategory){
        return productCategoryRepository.save(productCategory);
    }
}
