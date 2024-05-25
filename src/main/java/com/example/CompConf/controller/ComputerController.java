package com.example.CompConf.controller;

import com.example.CompConf.model.Complect;
import com.example.CompConf.model.Computer;
import com.example.CompConf.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/computer")
public class ComputerController {

    private final ComputerService computerService;

    @GetMapping("/{id}")
    public ResponseEntity<Computer> getComputerById(@PathVariable Long id) {
        Optional<Computer> computerDetails = computerService.getComputerById(id);
        return computerDetails.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createComputer(@RequestBody Computer computer) {
        computerService.createComputer(computer);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Computer> updateComputer(@PathVariable Long id, @RequestBody Computer computerDetails) {
        try {
            Computer updatedComputer = computerService.updateComputer(id, computerDetails);
            return ResponseEntity.ok(updatedComputer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComputer(@PathVariable Long id) {
        try {
            computerService.deleteComputer(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
