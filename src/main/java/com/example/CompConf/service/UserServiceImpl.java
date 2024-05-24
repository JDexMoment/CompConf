package com.example.CompConf.service;

import com.example.CompConf.model.User;
import com.example.CompConf.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void registerUser(User user) {

    }

    @Override
    public void loginUser(User user) {

    }

    @Override
    public List<User> getUsers() {
        return List.of();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public void addToWishList(User user) {

    }
}
