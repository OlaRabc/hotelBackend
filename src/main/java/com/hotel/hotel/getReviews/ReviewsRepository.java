package com.hotel.hotel.getReviews;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ReviewsRepository")
public interface ReviewsRepository extends JpaRepository<ReviewsEntity, Long> {

    public List<ReviewsEntity> findTop6ByOrderByReviewDateDesc();
}
