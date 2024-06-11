package com.example.CompConf.controller;

import com.example.CompConf.model.User;
import com.example.CompConf.model.WishList;
import com.example.CompConf.service.WishListService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserPostDeleteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private  WishListService wishListService;


    @Test
    void testAddToWishList() throws Exception {
        WishList wishList = new WishList();
        User user = new User();
        user.setId(1L);
        wishList.setId(1L);
        wishList.setUser(user);
        mockMvc.perform((RequestBuilder) post("/user/wishlist")
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.valueOf(objectMapper.writeValueAsString(wishList))))
                .andExpect(status().isCreated());
    }

    @Test
    void testRemoveFromWishList() throws Exception {
        WishList wishList = new WishList();
        User user = new User();
        user.setId(1L);
        wishList.setId(1L);
        wishList.setUser(user);

        mockMvc.perform(delete("/user/wishlist/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(wishList)))
                .andExpect(status().isNoContent());
    }
}
