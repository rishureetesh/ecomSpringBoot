package com.ecom.SpringBoot.repository;

import com.ecom.SpringBoot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
