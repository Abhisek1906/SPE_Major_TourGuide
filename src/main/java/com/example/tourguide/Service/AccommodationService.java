package com.example.tourguide.Service;

import com.example.tourguide.Entity.Accommodation;
import com.example.tourguide.Entity.AccommodationReviews;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccommodationService {
    String addAccommodation(Accommodation accommodation);

    List<Accommodation> getAllAccommodations(String name);

    String addReviewsForRestaurant(AccommodationReviews review);

    List<AccommodationReviews> getHotelReviews(String hotelName);
}
