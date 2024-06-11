package com.example.CompConf.service;

import com.example.CompConf.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    void postReview(Review review);

    Optional<Review> getReviewById(Long id);
    List<List<Review>> getAllReviewsByType(String type);
    List<Review> getReviewsByUserId(Long id);

    void deleteReviewById(Long id);
}
