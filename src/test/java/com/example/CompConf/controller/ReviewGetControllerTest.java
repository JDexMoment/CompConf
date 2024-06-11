package com.example.CompConf.controller;

import com.example.CompConf.model.Review;
import com.example.CompConf.service.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ReviewGetControllerTest {

    @Mock
    private ReviewService reviewService;

    @InjectMocks
    private ReviewGetController reviewGetController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetReviewById() {
        Long reviewId = 1L;
        Review review = new Review();
        when(reviewService.getReviewById(reviewId)).thenReturn(Optional.of(review));

        ResponseEntity<Review> response = reviewGetController.getReviewById(reviewId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(review, response.getBody());
    }

    @Test
    public void testGetReviewById_NotFound() {
        Long reviewId = 1L;
        when(reviewService.getReviewById(reviewId)).thenReturn(Optional.empty());

        ResponseEntity<Review> response = reviewGetController.getReviewById(reviewId);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void testGetReviewByType() {
        String type = "CPU";
        List<List<Review>> reviews = Arrays.asList(Arrays.asList(new Review(), new Review()), Arrays.asList(new Review()));
        when(reviewService.getAllReviewsByType(type)).thenReturn(reviews);

        ResponseEntity<List<List<Review>>> response = reviewGetController.getReviewByType(type);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(reviews, response.getBody());
    }

    @Test
    public void testGetReviewByUserId() {
        Long userId = 1L;
        List<Review> reviews = Arrays.asList(new Review(), new Review());
        when(reviewService.getReviewsByUserId(userId)).thenReturn(reviews);

        ResponseEntity<List<Review>> response = reviewGetController.getReviewByUserId(userId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(reviews, response.getBody());
    }

    @Test
    public void testGetReviewByUserId_NotFound() {
        Long userId = 1L;
        when(reviewService.getReviewsByUserId(userId)).thenReturn(Arrays.asList());

        ResponseEntity<List<Review>> response = reviewGetController.getReviewByUserId(userId);

        assertEquals(404, response.getStatusCodeValue());
    }
}
