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
        return complectService.getComplectById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Complect>> getComplectsByType(@PathVariable String type) {
        List<Complect> complects = complectService.getComplectsByType(type);
        return ResponseEntity.ok(complects);
    }
}
