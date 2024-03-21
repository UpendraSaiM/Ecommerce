package com.example.Ecom.controller;

import com.example.Ecom.model.User;
import com.example.Ecom.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public User registerUser(@RequestBody User request) {
        return userService.registerNewUser(request.getUsername(), request.getEmail(), request.getPassword());
    }

}