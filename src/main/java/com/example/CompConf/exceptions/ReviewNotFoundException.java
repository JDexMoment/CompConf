package com.example.CompConf.exceptions;

import com.example.CompConf.model.Review;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ReviewNotFoundException extends RuntimeException {
    private final Review review;
}
