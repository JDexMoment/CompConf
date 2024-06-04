package com.example.CompConf.controller;

import com.example.CompConf.model.Computer;
import com.example.CompConf.model.WishList;
import com.example.CompConf.service.UserService;
import com.example.CompConf.service.WishListService;
import com.example.CompConf.service.WishListServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private  WishListService wishListService;


    @Test
    void testAddToWishList() throws Exception {
        WishList wishList = new WishList();
        // Инициализация wishList

        mockMvc.perform((RequestBuilder) post("/computer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.valueOf(objectMapper.writeValueAsString(wishList))))
                .andExpect(status().isCreated());
    }

    @Test
    void testRemoveFromWishList() throws Exception {
        WishList wishList = new WishList();
        // Инициализация wishList

        mockMvc.perform(delete("/computer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(wishList)))
                .andExpect(status().isNoContent());
    }

    @Test
    void testGetComputersByUserId() throws Exception {
        List<Computer> computers = Arrays.asList(new Computer(), new Computer());
        Mockito.when(wishListService.getComputerByUserId(anyLong())).thenReturn(computers);

        mockMvc.perform(get("/user/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().json(objectMapper.writeValueAsString(computers)));
    }

    @Test
    void testGetWishListByUserId() throws Exception {
        List<WishList> wishLists = Arrays.asList(new WishList(), new WishList());
        Mockito.when(wishListService.getWishListByUserId(anyLong())).thenReturn(wishLists);

        mockMvc.perform(get("/user/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().json(objectMapper.writeValueAsString(wishLists)));
    }
}
