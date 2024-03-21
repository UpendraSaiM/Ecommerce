package com.example.Ecom.model;

import jakarta.persistence.Entity;
import lombok.Data;



@Entity
@Data
public class User{
    private Long id;
    private String username;
    private String email;
    private String password;

}