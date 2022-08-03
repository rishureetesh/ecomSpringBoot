package com.ecom.SpringBoot.repository;

import com.ecom.SpringBoot.model.ProductOrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderHistoryRepository extends JpaRepository<ProductOrderHistory, Long> {
}
