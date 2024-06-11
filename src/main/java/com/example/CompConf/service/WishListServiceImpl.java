package com.example.CompConf.service;

import com.example.CompConf.exceptions.UsernameNotFoundException;
import com.example.CompConf.exceptions.WishListNotFoundException;
import com.example.CompConf.model.Computer;
import com.example.CompConf.model.User;
import com.example.CompConf.model.WishList;
import com.example.CompConf.repository.ComputerRepository;
import com.example.CompConf.repository.UserRepository;
import com.example.CompConf.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishListServiceImpl implements WishListService {

    private final WishListRepository wishListRepository;

    private final UserRepository userRepository;

    private final ComputerRepository computerRepository;

    @Override
    public void addToWishList(WishList wishList){
        wishListRepository.save(wishList);
    }

    @Override
    public List<Computer> getComputersByWishList(Long id){
        Optional<WishList> wishList = wishListRepository.findById(id);
        if(wishList.isEmpty()){
            throw new WishListNotFoundException(id);
        }
        return computerRepository.findByWishListId(id);
    }

    @Override
    public List<WishList> getWishListByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return wishListRepository.findByUserId(userId);
        } else {
            throw new UsernameNotFoundException(userId);
        }
    }

    @Override
    public void removeFromWishList(Long id) {
        wishListRepository.deleteById(id);
    }
}
