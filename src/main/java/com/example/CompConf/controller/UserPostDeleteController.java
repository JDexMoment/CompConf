package com.example.CompConf.controller;

import com.example.CompConf.model.WishList;
import com.example.CompConf.service.WishListServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserPostDeleteController {

    private final WishListServiceImpl wishListService;

    @PostMapping("/wishlist")
    public ResponseEntity<Void> addToWishList(@RequestBody WishList wishList) {
        wishListService.addToWishList(wishList);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("wishlist/{id}")
    public ResponseEntity<Void> removeFromWishList(@PathVariable Long id) {
        wishListService.removeFromWishList(id);
        return ResponseEntity.ok().build();
    }
}
