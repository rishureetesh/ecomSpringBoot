package com.ecom.SpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "mobilenumber", unique = true, nullable = false)
    private String mobilenumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "emailid", unique = true, nullable = false)
    private String emailid;
}
