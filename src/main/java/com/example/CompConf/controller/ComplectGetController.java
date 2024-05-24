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
        List<Complect> complects = complectService.getCPU();
        return ResponseEntity.ok(complects);
    }

    @GetMapping("/GPU")
    public ResponseEntity<List<Complect>> getGPU() {
        List<Complect> complects = complectService.getGPU();
        return ResponseEntity.ok(complects);
    }

    @GetMapping("/MotherBoard")
    public ResponseEntity<List<Complect>> getMotherBoard() {
        List<Complect> complects = complectService.getMotherBoard();
        return ResponseEntity.ok(complects);
    }

    @GetMapping("/Cooler")
    public ResponseEntity<List<Complect>> getCooler() {
        List<Complect> complects = complectService.getCooler();
        return ResponseEntity.ok(complects);
    }

    @GetMapping("/RAM")
    public ResponseEntity<List<Complect>> getRAM() {
        List<Complect> complects = complectService.getRAM();
        return ResponseEntity.ok(complects);
    }

    @GetMapping("/SSD")
    public ResponseEntity<List<Complect>> getSSD() {
        List<Complect> complects = complectService.getSSD();
        return ResponseEntity.ok(complects);
    }

    @GetMapping("/HDD")
    public ResponseEntity<List<Complect>> getHDD() {
        List<Complect> complects = complectService.getHDD();
        return ResponseEntity.ok(complects);
    }

    @GetMapping("/ComputerCase")
    public ResponseEntity<List<Complect>> getComputerCase() {
        List<Complect> complects = complectService.getComputerCase();
        return ResponseEntity.ok(complects);
    }

    @GetMapping("/PowerUnit")
    public ResponseEntity<List<Complect>> getPowerUnit() {
        List<Complect> complects = complectService.getPowerUnit();
        return ResponseEntity.ok(complects);
    }
}
