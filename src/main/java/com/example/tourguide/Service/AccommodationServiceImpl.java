package com.example.tourguide.Service;

import com.example.tourguide.Entity.Accommodation;
import com.example.tourguide.Entity.AccommodationReviews;
import com.example.tourguide.Entity.Place;
import com.example.tourguide.Entity.RestaurantReviews;
import com.example.tourguide.Repository.AccommodationRepo;
import com.example.tourguide.Repository.AccommodationReviewsRepo;
import com.example.tourguide.Repository.PlaceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccommodationServiceImpl implements AccommodationService{

    private final AccommodationRepo accommodationRepo;
    private final PlaceRepo placeRepo;
    private final AccommodationReviewsRepo accommodationReviewsRepo;
    @Override
    public String addAccommodation(Accommodation accommodation) {
        Accommodation accommodation1=accommodationRepo.save(accommodation);
        if(accommodation1!=null)
            return "Success!";
        else
            return "Failed to add place!";
    }

    @Override
    public List<Accommodation> getAllAccommodations(String name) {
        Place place= placeRepo.findByName(name);
        return place.getAccommodationList();
    }

    @Override
    public String addReviewsForRestaurant(AccommodationReviews review) {
        AccommodationReviews reviews1=accommodationReviewsRepo.save(review);
        if(reviews1!=null)
            return "Added Successfully!";
        else return "Failed";
    }

    @Override
    public List<AccommodationReviews> getHotelReviews(String hotelName) {
        Accommodation accommodation=accommodationRepo.findByName(hotelName);
        return accommodation.getAccommodationReviewsList();
    }
}
