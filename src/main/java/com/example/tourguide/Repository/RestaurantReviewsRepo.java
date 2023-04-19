package com.example.tourguide.Repository;

import com.example.tourguide.Entity.RestaurantReviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantReviewsRepo extends JpaRepository<RestaurantReviews,Integer> {
}
