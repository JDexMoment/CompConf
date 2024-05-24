package com.example.CompConf.controller;

import com.example.CompConf.model.User;
import com.example.CompConf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    ResponseEntity<Void> registerUser(User user) {
        userService.registerUser(user);
        return ResponseEntity.ok().build();
    }

    ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    ResponseEntity<User> getUserById(Long id) {
        Optional<User> userOptional = userService.getUserById(id);
        return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    ResponseEntity<Void> loginUser(User user) {
        userService.loginUser(user);
        return ResponseEntity.ok().build();
    }
}