package com.example.CompConf.service;

import com.example.CompConf.exceptions.UsernameNotFoundException;
import com.example.CompConf.model.Computer;
import com.example.CompConf.model.User;
import com.example.CompConf.model.WishList;
import com.example.CompConf.repository.UserRepository;
import com.example.CompConf.repository.WishListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WishListServiceImplTest {

    @Mock
    private WishListRepository wishListRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private WishListServiceImpl wishListService;

    @Test
    void addToWishList() {
        WishList wishList = new WishList();
        wishListService.addToWishList(wishList);
        verify(wishListRepository, times(1)).save(wishList);
    }


    @Test
    void getWishListByUserId() {
        Long userId = 1L;
        List<WishList> wishLists = new ArrayList<>();
        WishList wishList1 = new WishList();
        WishList wishList2 = new WishList();
        wishLists.add(wishList1);
        wishLists.add(wishList2);
        when(userRepository.findById(userId)).thenReturn(Optional.of(new User()));
        when(wishListRepository.findByUserId(userId)).thenReturn(wishLists);
        List<WishList> result = wishListService.getWishListByUserId(userId);
        assertEquals(2, result.size());
    }

    @Test
    void removeFromWishList() {
        WishList wishList = new WishList();
        wishListService.removeFromWishList(1L);
        verify(wishListRepository, times(1)).delete(wishList);
    }
}
