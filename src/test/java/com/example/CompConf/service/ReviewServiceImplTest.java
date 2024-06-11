package com.example.CompConf.service;

import com.example.CompConf.model.Complect;
import com.example.CompConf.model.Review;
import com.example.CompConf.model.User;
import com.example.CompConf.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceImplTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    @Test
    public void testPostReview() {
        Review review = new Review();

        User user = new User();
        user.setId(1L);

        Complect complect = new Complect();
        complect.setId(1L);

        review.setId(1L);
        review.setComplect(complect);
        review.setUser(user);
        review.setRating(4);
        review.setReview("This is a test");

        reviewService.postReview(review);

        Mockito.verify(reviewRepository, Mockito.times(1)).save(review);
    }
}

