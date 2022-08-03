package com.ecom.SpringBoot.repository;

import com.ecom.SpringBoot.model.UserAddresses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddresses, Long> {
}
