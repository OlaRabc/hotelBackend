package com.hotel.hotel.getReviews;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "reviews")
public class ReviewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @NonNull
    private String userFullName;
    @NonNull
    private String reviewDate;

    @NonNull
    private int rating;

    @NonNull
    private String reviewText;


}