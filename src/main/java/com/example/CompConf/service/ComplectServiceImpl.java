package com.example.CompConf.service;

import com.example.CompConf.exceptions.ComplectNotFoundException;
import com.example.CompConf.exceptions.ReviewNotFoundException;
import com.example.CompConf.model.Complect;
import com.example.CompConf.model.Review;
import com.example.CompConf.repository.ComplectRepository;
import com.example.CompConf.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ComplectServiceImpl implements ComplectService {

    private final ComplectRepository complectRepository;

    private final ReviewRepository reviewRepository;

    private void findAndUpdateComplectRating(Long id) {
        Optional<Complect> complectOptional = complectRepository.findById(id);
        if (complectOptional.isEmpty()) {
            throw new ComplectNotFoundException(id);
        }

        Complect complect = complectOptional.get();
        List<Review> reviews = reviewRepository.findByComplectId(id);
        if (reviews.isEmpty()) {
            throw new ReviewNotFoundException((Review) reviews);
        }

        double averageRating = reviews.stream()
                .collect(Collectors.averagingDouble(Review::getRating));
        complect.setRating(averageRating);
        complectRepository.save(complect);

    }

    @Override
    @Transactional
    public Optional<Complect> getComplectById(Long id) {
        findAndUpdateComplectRating(id);
        return complectRepository.findById(id);
    }

    @Override
    @Transactional
    public void registerComplect(Complect complect) {
        complectRepository.save(complect);
    }

    @Override
    @Transactional
    public List<Complect> getComplectsByType(String type) {
        List<Complect> complects = complectRepository.findTopRatedComplectByType(type);
        return complects.stream()
                .peek(complect -> findAndUpdateComplectRating(complect.getId()))
                .collect(Collectors.toList());
    }
}
