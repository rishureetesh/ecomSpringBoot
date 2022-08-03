package com.ecom.SpringBoot.repository;

import com.ecom.SpringBoot.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
