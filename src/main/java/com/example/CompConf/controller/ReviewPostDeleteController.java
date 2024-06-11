package com.example.CompConf.controller;

import com.example.CompConf.model.Review;
import com.example.CompConf.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/review")
public class ReviewPostDeleteController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Void> postReview(@RequestBody Review review) {
        reviewService.postReview(review);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReviewById(id);
        return ResponseEntity.ok().build();
    }

}
