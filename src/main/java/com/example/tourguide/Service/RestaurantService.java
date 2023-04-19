package com.example.tourguide.Service;

import com.example.tourguide.Entity.Restaurant;
import com.example.tourguide.Entity.RestaurantReviews;

import java.util.List;

public interface RestaurantService {
    String addRestaurant(Restaurant restaurant);

    String addReviewsForRestaurant(RestaurantReviews reviews);

    List<RestaurantReviews> getAllReviews(String restaurantName);
}
