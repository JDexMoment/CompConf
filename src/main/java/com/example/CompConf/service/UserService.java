package com.example.CompConf.service;

import com.example.CompConf.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void registerUser(User user);
    void loginUser(User user);
    List<User> getUsers();
    Optional<User> getUserById(Long id);
    void addToWishList(User user);
}