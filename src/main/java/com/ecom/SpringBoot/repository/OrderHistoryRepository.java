package com.ecom.SpringBoot.repository;

import com.ecom.SpringBoot.model.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
}
