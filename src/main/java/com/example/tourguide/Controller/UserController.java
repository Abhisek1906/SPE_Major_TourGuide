package com.example.tourguide.Controller;

import com.example.tourguide.Entity.*;
import com.example.tourguide.Service.AccommodationService;
import com.example.tourguide.Service.PlaceService;
import com.example.tourguide.Service.RegionService;
import com.example.tourguide.Service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final PlaceService placeService;
    private final RestaurantService restaurantService;
    private final AccommodationService accommodationService;

    private final RegionService regionService;

    @GetMapping("/getPlace/{name}")
    public ResponseEntity<?> getPlace(@PathVariable("name") String name){
        Place place=placeService.getPlace(name);
        if(place==null)
            return ResponseEntity.status(400).body("Sorry , not found!");
        return ResponseEntity.status(200).body(place);
    }

    @GetMapping("/getAllAccommodation/{placeName}")
    public ResponseEntity<?> getAllAccommodation(@PathVariable("placeName") String name){
        List<Accommodation> accommodations=accommodationService.getAllAccommodations(name);
        if(accommodations.size()==0)
            return ResponseEntity.status(400).body("No accommodations found here.");
        return ResponseEntity.status(200).body(accommodations);
    }

    @GetMapping("/getAllOffBeatPlaces/{placeName}")
    public ResponseEntity<?> getAllOffBeatPlaces(@PathVariable("placeName") String name){
        List<OffBeatPlaces> placesList=placeService.getAllOffBeatPlaces(name);
        if(placesList.size()==0)
            return ResponseEntity.status(400).body("No places found here.");
        return ResponseEntity.status(200).body(placesList);
    }

    @GetMapping("/getAllRestaurants/{placeName}")
    public ResponseEntity<?> getAllRestaurants(@PathVariable("placeName") String name){
        List<Restaurant> restaurantList=placeService.getAllRestaurants(name);
        if(restaurantList.size()==0)
            return ResponseEntity.status(400).body("No places found here.");
        return ResponseEntity.status(200).body(restaurantList);
    }
    @GetMapping("/getAllActivitiesInaPlace/{offBeatId}")
    public ResponseEntity<?> getAllActivitiesInaPlace(@PathVariable("offBeatId") int offBeatId){
        List<Activities> activitiesList=placeService.getAllActivitiesInaPlace(offBeatId);
        if(activitiesList.size()==0)
            return ResponseEntity.status(400).body("No places found here.");
        return ResponseEntity.status(200).body(activitiesList);
    }

    @GetMapping("/getAllFoodsForaPlace/{placeName}")
    public ResponseEntity<?> getAllFoodsForaPlace(@PathVariable("placeName") String name){
        List<Foods> foodsList=placeService.getAllFoodsForaPlace(name);
        if(foodsList.size()==0)
            return ResponseEntity.status(400).body("No places found here.");
        return ResponseEntity.status(200).body(foodsList);
    }

    @GetMapping("/getAllReviews/{restaurantName}")
    public ResponseEntity<?> getAllReviews(@PathVariable("restaurantName") String restaurantName){
        List<RestaurantReviews> reviewsList=restaurantService.getAllReviews(restaurantName);
        if(reviewsList.size()==0)
            return ResponseEntity.status(400).body("No places found here.");
        return ResponseEntity.status(200).body(reviewsList);
    }

    @GetMapping("/getAllPlaces/{regionName}")
    public ResponseEntity<?> getAllPlaces(@PathVariable("regionName") String regionName){
        List<Place> places=regionService.getAllPlaces(regionName);
        if(places.size()==0)
            return ResponseEntity.status(400).body("No places found here.");
        return ResponseEntity.status(200).body(places);
    }

    @PostMapping("/addReviewForAccommodation")
    public ResponseEntity<String> addReviewForAccommodation(@RequestBody AccommodationReviews review){
        String str=accommodationService.addReviewsForRestaurant(review);
        return ResponseEntity.status(200).body(str);
    }

    @GetMapping("/getHotelReviews/{hotelName}")
    public ResponseEntity<?> getHotelReviews(@PathVariable("hotelName") String hotelName){
        List<AccommodationReviews> reviewsList=accommodationService.getHotelReviews(hotelName);
        if(reviewsList.size()==0)
            return ResponseEntity.status(400).body("No reviews found here.");
        return ResponseEntity.status(200).body(reviewsList);
    }
}
