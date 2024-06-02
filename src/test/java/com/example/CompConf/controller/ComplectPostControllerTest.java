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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ComplectPostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ComplectService complectService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testRegisterComplect() throws Exception {
        Complect complect = new Complect();
        complect.setId(1L);
        complect.setType("CPU");
        complect.setName("Intel Core i5-12400F LGA1700 OEM");
        complect.setCost(16424);
        complect.setDescription("Процессор Intel Core i5-12400F");

        Mockito.doNothing().when(complectService).registerComplect(Mockito.any(Complect.class));

        mockMvc.perform(post("/complect")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(complect)))
                .andExpect(status().isOk());

        Mockito.verify(complectService, Mockito.times(1)).registerComplect(Mockito.any(Complect.class));
    }
}
