package com.example.tourguide.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantReviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurantReviewId;

    private String review;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "restaurant_id",nullable = false)
    @JsonBackReference
    private Restaurant restaurant;
}
