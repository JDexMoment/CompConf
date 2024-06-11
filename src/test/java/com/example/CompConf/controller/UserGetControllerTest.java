package com.example.CompConf.controller;

import com.example.CompConf.model.Computer;
import com.example.CompConf.model.WishList;
import com.example.CompConf.service.WishListServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserGetControllerTest {

    @Mock
    private WishListServiceImpl wishListService;

    @InjectMocks
    private UserGetController userGetController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetComputersByWishList() {
        Long wishListId = 1L;
        List<Computer> computers = Arrays.asList(new Computer(), new Computer());
        when(wishListService.getComputersByWishList(wishListId)).thenReturn(computers);

        ResponseEntity<List<Computer>> response = userGetController.getComputersByWishList(wishListId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(computers, response.getBody());
    }

    @Test
    public void testGetWishListByUserId() {
        Long userId = 1L;
        List<WishList> wishLists = Arrays.asList(new WishList(), new WishList());
        when(wishListService.getWishListByUserId(userId)).thenReturn(wishLists);

        ResponseEntity<List<WishList>> response = userGetController.getWishListByUserId(userId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(wishLists, response.getBody());
    }
}
