package com.example.CompConf.controller;

import com.example.CompConf.model.Complect;
import com.example.CompConf.model.Computer;
import com.example.CompConf.service.ComputerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/computer")
public class ComputerController {

    private final ComputerService computerService;

    @GetMapping("/{id}")
    public ResponseEntity<Computer> getComputerById(@PathVariable Long id) {
        log.info("Received GET request for computer with id {}", id);
        Optional<Computer> computerDetails = computerService.getComputerById(id);
        return computerDetails.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createComputer(@RequestBody Computer computer) {
        log.info("Received POST request for computer: {}", computer);
        computerService.createComputer(computer);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Computer> updateComputer(@PathVariable Long id, @RequestBody Computer computerDetails) {
        log.info("Received PUT request for computer with id {}", id);
        try {
            Computer updatedComputer = computerService.updateComputer(id, computerDetails);
            return ResponseEntity.ok(updatedComputer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComputer(@PathVariable Long id) {
        log.info("Received DELETE request for computer with id {}", id);
        try {
            computerService.deleteComputer(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
