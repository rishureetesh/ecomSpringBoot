package com.ecom.SpringBoot.repository;

import com.ecom.SpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
