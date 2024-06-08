package com.example.CompConf.controller;

import com.example.CompConf.model.Complect;
import com.example.CompConf.service.ComplectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/complect")
@Slf4j
public class ComplectPostController {
    private final ComplectService complectService;

    @PostMapping
    public ResponseEntity<Void> registerComplect(@RequestBody Complect complect) {
        complectService.registerComplect(complect);
        return ResponseEntity.ok().build();
    }
}
