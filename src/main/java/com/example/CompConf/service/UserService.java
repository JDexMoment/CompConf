package com.example.CompConf.service;

import com.example.CompConf.model.Computer;
import com.example.CompConf.model.User;
import com.example.CompConf.model.WishList;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void registration(String username, String password);
}
