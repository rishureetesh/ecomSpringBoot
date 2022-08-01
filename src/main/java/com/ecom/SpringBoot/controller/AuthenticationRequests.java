package com.ecom.SpringBoot.controller;

import com.ecom.SpringBoot.model.AuthenticationRequest;
import com.ecom.SpringBoot.security.JWTSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationRequests {

    @Autowired
    private JWTSecurity jwtSecurity;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/auth/login")
    public String Authentication(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmailid(), authenticationRequest.getPassword())
            );
        }catch(Exception e){
            throw new Exception("Invalid EmailId or Password");
        }
        return jwtSecurity.generateToken(authenticationRequest.getEmailid());
    }
}
