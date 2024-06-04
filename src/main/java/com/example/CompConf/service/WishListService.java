package com.example.CompConf.service;

import com.example.CompConf.model.Computer;
import com.example.CompConf.model.WishList;

import java.util.List;
import java.util.Optional;

public interface WishListService {

    void addToWishList(WishList wishList);

    List<Computer> getComputerByUserId(Long id);

    List<WishList> getWishListByUserId(Long id);

    void removeFromWishList(WishList wishList);
}
