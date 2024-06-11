package com.example.CompConf.controller;

import com.example.CompConf.model.Complect;
import com.example.CompConf.service.ComplectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ComplectGetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ComplectService complectService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetComplectById() throws Exception {
        Complect complect = new Complect();
        complect.setId(1L);
        complect.setType("CPU");
        complect.setName("Intel Core i5-12400F LGA1700 OEM");
        complect.setCost(16424);
        complect.setDescription("Процессор Intel Core i5-12400F");

        Mockito.when(complectService.getComplectById(1L)).thenReturn(Optional.of(complect));

        mockMvc.perform(get("/complect/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(complect)));
    }

}
