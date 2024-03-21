package com.example.Ecom.service;

import com.example.Ecom.model.User;
import com.example.Ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerNewUser(String username, String email, String password) {
        if (userRepository.existsByUsername(username) || userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Username or email already exists");
        }
        User newuser = new User();
        newuser.setUsername(username);
        newuser.setEmail(email);
        newuser.setPassword(passwordEncoder.encode(password));
        return userRepository.save(newuser);

    }
}