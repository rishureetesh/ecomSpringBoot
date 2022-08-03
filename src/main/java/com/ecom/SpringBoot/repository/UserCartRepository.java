package com.ecom.SpringBoot.repository;

import com.ecom.SpringBoot.model.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCartRepository extends JpaRepository<UserCart, Long> {
}
