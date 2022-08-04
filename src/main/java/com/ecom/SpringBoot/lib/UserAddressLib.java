package com.ecom.SpringBoot.lib;

import com.ecom.SpringBoot.model.UserAddresses;
import com.ecom.SpringBoot.repository.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class UserAddressLib {

    @Autowired
    private UserAddressRepository userAddressRepository;

    public UserAddresses addUserAddress(@RequestBody UserAddresses userAddresses){
        return userAddressRepository.save(userAddresses);
    }
}
