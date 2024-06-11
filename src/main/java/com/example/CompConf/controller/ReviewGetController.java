package com.example.CompConf.controller;

import com.example.CompConf.model.Review;
import com.example.CompConf.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/review")
public class ReviewGetController {

    private final ReviewService reviewService;


    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<List<Review>>> getReviewByType(@PathVariable String type) {
        List<List<Review>> reviews = reviewService.getAllReviewsByType(type);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Review>> getReviewByUserId(@PathVariable Long id) {
        List<Review> reviews = reviewService.getReviewsByUserId(id);
        if (reviews.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reviews);
    }
}
