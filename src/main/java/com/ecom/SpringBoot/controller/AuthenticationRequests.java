package com.ecom.SpringBoot.controller;

import com.ecom.SpringBoot.model.AuthenticationRequest;
import com.ecom.SpringBoot.model.User;
import com.ecom.SpringBoot.repository.UserRepository;
import com.ecom.SpringBoot.security.JWTSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthenticationRequests {

    @Autowired
    private JWTSecurity jwtSecurity;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/authentication")
    public ResponseEntity<?> Authentication(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmailid(), authenticationRequest.getPassword())
            );
        }catch(Exception e){
            throw new Exception("Invalid EmailId or Password");
        }
        String token = jwtSecurity.generateToken(authenticationRequest.getEmailid());
        Cookie cookie = new Cookie("ecomToken", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        response.addCookie(cookie);
        return ResponseEntity.ok("");
    }

    @PostMapping("/register")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
