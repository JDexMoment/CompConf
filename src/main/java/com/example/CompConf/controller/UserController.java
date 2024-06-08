package com.example.CompConf.controller;

import com.example.CompConf.model.Computer;
import com.example.CompConf.model.WishList;
import com.example.CompConf.service.WishListServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserController {

    private final WishListServiceImpl wishListService;

    @PostMapping("/wishlist")
    public ResponseEntity<Void> addToWishList(@RequestBody WishList wishList) {
        log.info("Received POST request with wishlist: {}",wishList);
        wishListService.addToWishList(wishList);
        log.info("Saved wishlist: {}", wishList);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("wishlist/{id}")
    public ResponseEntity<Void> removeFromWishList(@RequestBody WishList wishList) {
        log.info("Received DELETE request with wishlist: {}",wishList);
        wishListService.removeFromWishList(wishList);
        log.info("Deleted wishlist: {}", wishList);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/wishlist")
    public ResponseEntity<List<Computer>> getComputersByUserId(@PathVariable Long userId) {
        log.info("Received GET request for Computers by user with id: {}", userId);
        List<Computer> computers = wishListService.getComputerByUserId(userId);
        return ResponseEntity.ok(computers);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<WishList>> getWishListByUserId(@PathVariable Long userId) {
        log.info("Received GET request for WishLists by user with id: {}", userId);
        List<WishList> wishLists = wishListService.getWishListByUserId(userId);
        return ResponseEntity.ok(wishLists);
    }
}
