package com.example.CompConf.service;

import com.example.CompConf.exceptions.ReviewNotFoundException;
import com.example.CompConf.exceptions.UserNotFoundException;
import com.example.CompConf.model.Complect;
import com.example.CompConf.model.Review;
import com.example.CompConf.model.User;
import com.example.CompConf.repository.ComplectRepository;
import com.example.CompConf.repository.ReviewRepository;
import com.example.CompConf.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final ComplectRepository complectRepository;

    private final UserRepository userRepository;

    @Override
    public void postReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public Optional<Review> getReviewById(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isEmpty()) {
            throw new ReviewNotFoundException((Review) null);
        }
        return review;
    }

    @Override
    public List<List<Review>> getAllReviewsByType(String type) {
        List<Complect> complects = complectRepository.findTopRatedComplectByType(type);
        List<List<Review>> reviews = new ArrayList<>();
        for (Complect complect : complects) {
            reviews.add(reviewRepository.findByComplectId(complect.getId()));
        }
        return reviews;
    }

    @Override
    public List<Review> getReviewsByUserId(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return reviewRepository.findByUserId(id);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }
}
