package com.example.SpringBootSecurityTest.modal;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    private String role; //ROLE_USER, ROLE_ADMIN etc.
}
