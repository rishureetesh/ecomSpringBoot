package com.ecom.SpringBoot.controller;

import com.ecom.SpringBoot.model.UserAddresses;
import com.ecom.SpringBoot.repository.UserAddressRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/addresses")
public class UserAddressesController {

    @Autowired
    private UserAddressRepository userAddressRepository;

    @GetMapping
    public List<UserAddresses> getUserAddresses(){
        return userAddressRepository.findAll();
    }

    @PostMapping
    public UserAddresses addUserAddress(@RequestBody UserAddresses userAddresses){
        return userAddressRepository.save(userAddresses);
    }

    @GetMapping("{username}")
    public List<UserAddresses> getUserAddressByUsername(){
        return userAddressRepository.findAll();
    }

}
