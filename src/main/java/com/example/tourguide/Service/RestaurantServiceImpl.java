package com.example.tourguide.Service;

import com.example.tourguide.Entity.Restaurant;
import com.example.tourguide.Entity.RestaurantReviews;
import com.example.tourguide.Repository.RestaurantRepo;
import com.example.tourguide.Repository.RestaurantReviewsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{
    private final RestaurantRepo restaurantRepo;

    private final RestaurantReviewsRepo reviewsRepo;

    @Override
    public String addRestaurant(Restaurant restaurant) {
        Restaurant restaurant1=restaurantRepo.save(restaurant);
        if(restaurant1!=null)
            return "Added Successfully!";
        else return "Failed";
    }

    @Override
    public String addReviewsForRestaurant(RestaurantReviews reviews) {
        RestaurantReviews reviews1=reviewsRepo.save(reviews);
        if(reviews1!=null)
            return "Added Successfully!";
        else return "Failed";
    }

    @Override
    public List<RestaurantReviews> getAllReviews(String restaurantName) {
        Restaurant restaurant=restaurantRepo.findByName(restaurantName);
        return restaurant.getReviewsList();
    }
}
