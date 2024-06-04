package com.example.CompConf.controller;

import com.example.CompConf.model.Complect;
import com.example.CompConf.service.ComplectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/complect")
@Slf4j
public class ComplectGetController {
    private final ComplectService complectService;

    @GetMapping("/{id}")
    public ResponseEntity<Complect> getComplectById(@PathVariable Long id) {
        log.info("Received GET request for complect with id: {}", id);
        return complectService.getComplectById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/CPU")
    public ResponseEntity<List<Complect>> getCPU() {
        log.info("Received GET request for CPU");
        List<Complect> complects = complectService.getCPU();
        return ResponseEntity.ok(complects);
    }

    @GetMapping("/GPU")
    public ResponseEntity<List<Complect>> getGPU() {
        log.info("Received GET request for GPU");
        List<Complect> complects = complectService.getGPU();
        return ResponseEntity.ok(complects);
    }

    @GetMapping("/MotherBoard")
    public ResponseEntity<List<Complect>> getMotherBoard() {
        log.info("Received GET request for MotherBoard");
        List<Complect> complects = complectService.getMotherBoard();
        return ResponseEntity.ok(complects);
    }

    @GetMapping("/Cooler")
    public ResponseEntity<List<Complect>> getCooler() {
        log.info("Received GET request for Cooler");
        List<Complect> complects = complectService.getCooler();
        return ResponseEntity.ok(complects);
    }

    @GetMapping("/RAM")
    public ResponseEntity<List<Complect>> getRAM() {
        log.info("Received GET request for RAM");
        List<Complect> complects = complectService.getRAM();
        return ResponseEntity.ok(complects);
    }

    @GetMapping("/SSD")
    public ResponseEntity<List<Complect>> getSSD() {
        log.info("Received GET request for SSD");
        List<Complect> complects = complectService.getSSD();
        return ResponseEntity.ok(complects);
    }

    @GetMapping("/HDD")
    public ResponseEntity<List<Complect>> getHDD() {
        log.info("Received GET request for HDD");
        List<Complect> complects = complectService.getHDD();
        return ResponseEntity.ok(complects);
    }

    @GetMapping("/ComputerCase")
    public ResponseEntity<List<Complect>> getComputerCase() {
        log.info("Received GET request for ComputerCase");
        List<Complect> complects = complectService.getComputerCase();
        return ResponseEntity.ok(complects);
    }

    @GetMapping("/PowerUnit")
    public ResponseEntity<List<Complect>> getPowerUnit() {
        log.info("Received GET request for PowerUnit");
        List<Complect> complects = complectService.getPowerUnit();
        return ResponseEntity.ok(complects);
    }
}
