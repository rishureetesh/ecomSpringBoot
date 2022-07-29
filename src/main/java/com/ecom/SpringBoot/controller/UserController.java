package com.ecom.SpringBoot.controller;

import com.ecom.SpringBoot.exceptions.ResourceNotFoundException;
import com.ecom.SpringBoot.model.User;
import com.ecom.SpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        User user = userRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("User doesn't exit with the id: "+id));
        return ResponseEntity.ok(user);
    }
}
