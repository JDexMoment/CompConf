package com.example.CompConf.service;

import com.example.CompConf.exceptions.UsernameNotFoundException;
import com.example.CompConf.model.Computer;
import com.example.CompConf.model.User;
import com.example.CompConf.model.WishList;
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

    @Override
    public void addToWishList(WishList wishList){
        wishListRepository.save(wishList);
    }

    @Override
    public List<Computer> getComputerByUserId(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            List<WishList> wishLists = wishListRepository.findByUserId(id);
            List<Computer> computers = new ArrayList<>();
            for(WishList wishList : wishLists){
                computers.addAll(wishList.getComputers());
            }
            return computers;
        } else {
            throw new UsernameNotFoundException(id);
        }
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
    public void removeFromWishList(WishList wishList) {
        wishListRepository.delete(wishList);
    }
}
