package com.hotel.hotel.getReviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetReviewController {

    ReviewsRepository reviewsRepository;

    public GetReviewController(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    @GetMapping("/last-reviews")
    public ResponseEntity<?> getLastReviews() {
        return new ResponseEntity(reviewsRepository.findTop6ByOrderByReviewDateDesc(), HttpStatus.OK);

    }
}
