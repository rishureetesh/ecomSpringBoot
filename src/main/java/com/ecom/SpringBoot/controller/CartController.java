package com.ecom.SpringBoot.controller;

import com.ecom.SpringBoot.model.UserCart;
import com.ecom.SpringBoot.repository.UserCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
@RequestMapping("/api/cart/user")
public class CartController {

    @Autowired
    private UserCartRepository userCartRepository;

    @GetMapping
    public List<UserCart> getUserCart(){
        return userCartRepository.findAll();
    }
}
