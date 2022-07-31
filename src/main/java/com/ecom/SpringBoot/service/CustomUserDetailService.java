package com.ecom.SpringBoot.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.ecom.SpringBoot.model.User;
import com.ecom.SpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private static Logger logger = Logger.getLogger("Logging Info!!!");

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByemailid(username);
        logger.info(username+", "+user.getEmailid()+" : "+user.getPassword());
        return new org.springframework.security.core.userdetails.User(user.getEmailid(), user.getPassword(), new ArrayList<>());
    }
}
