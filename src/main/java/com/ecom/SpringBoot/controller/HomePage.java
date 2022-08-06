package com.ecom.SpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomePage {

    @GetMapping("")
    public String homePage(){
        return "You are on HomePage!!!";
    }
    @GetMapping("/ping")
    public Map pingPong(){
        HashMap map = new HashMap<>();
        map.put("success",true);
        map.put("msg","Ping Pong");
        return map;
    }
}
