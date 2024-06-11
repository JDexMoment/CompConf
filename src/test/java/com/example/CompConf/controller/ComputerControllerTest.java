package com.example.CompConf.controller;

import com.example.CompConf.model.Computer;
import com.example.CompConf.service.ComputerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ComputerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ComputerService computerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetComputerById() throws Exception {
        Computer computer = new Computer();
        computer.setId(1L);

        when(computerService.getComputerById(1L)).thenReturn(Optional.of(computer));

        mockMvc.perform(get("/computer/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Test Computer"));

        verify(computerService, times(1)).getComputerById(1L);
    }

    @Test
    void testGetComputerByIdNotFound() throws Exception {
        when(computerService.getComputerById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/computer/{id}", 1L))
                .andExpect(status().isNotFound());

        verify(computerService, times(1)).getComputerById(1L);
    }

    @Test
    void testCreateComputer() throws Exception {
        Computer computer = new Computer();
        computer.setId(1L);

        doNothing().when(computerService).createComputer(any(Computer.class));

        mockMvc.perform(post("/computer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(computer)))
                .andExpect(status().isOk());

        verify(computerService, times(1)).createComputer(any(Computer.class));
    }

    @Test
    void testUpdateComputer() throws Exception {
        Computer computer = new Computer();
        computer.setId(1L);

        when(computerService.updateComputer(eq(1L), any(Computer.class))).thenReturn(computer);

        mockMvc.perform(put("/computer/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(computer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Updated Computer"));

        verify(computerService, times(1)).updateComputer(eq(1L), any(Computer.class));
    }

    @Test
    void testUpdateComputerNotFound() throws Exception {
        Computer computer = new Computer();
        computer.setId(1L);

        when(computerService.updateComputer(eq(1L), any(Computer.class))).thenThrow(new RuntimeException("Not found"));

        mockMvc.perform(put("/computer/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(computer)))
                .andExpect(status().isNotFound());

        verify(computerService, times(1)).updateComputer(eq(1L), any(Computer.class));
    }

    @Test
    void testDeleteComputer() throws Exception {
        doNothing().when(computerService).deleteComputer(1L);

        mockMvc.perform(delete("/computer/{id}", 1L))
                .andExpect(status().isNoContent());

        verify(computerService, times(1)).deleteComputer(1L);
    }

    @Test
    void testDeleteComputerNotFound() throws Exception {
        doThrow(new RuntimeException("Not found")).when(computerService).deleteComputer(1L);

        mockMvc.perform(delete("/computer/{id}", 1L))
                .andExpect(status().isNotFound());

        verify(computerService, times(1)).deleteComputer(1L);
    }
}
