package com.example.CompConf.controller;

import com.example.CompConf.model.Computer;
import com.example.CompConf.model.WishList;
import com.example.CompConf.service.WishListServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserGetController {

    private final WishListServiceImpl wishListService;

    @GetMapping("/wishlist/{id}")
    public ResponseEntity<List<Computer>> getComputersByWishList(@PathVariable Long id) {
        List<Computer> computers = wishListService.getComputersByWishList(id);
        return ResponseEntity.ok(computers);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<WishList>> getWishListByUserId(@PathVariable Long userId) {
        List<WishList> wishLists = wishListService.getWishListByUserId(userId);
        return ResponseEntity.ok(wishLists);
    }
}
