package com.example.tourguide.Controller;

import com.example.tourguide.Entity.*;
import com.example.tourguide.Service.AccommodationService;
import com.example.tourguide.Service.PlaceService;
import com.example.tourguide.Service.RegionService;
import com.example.tourguide.Service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private static final ch.qos.logback.classic.Logger log= (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(UserController.class);

    private final PlaceService placeService;
    private final RestaurantService restaurantService;
    private final AccommodationService accommodationService;

    private final RegionService regionService;

    @GetMapping("/getPlace/{name}")
    public ResponseEntity<?> getPlace(@PathVariable("name") String name){
        Place place=placeService.getPlace(name);
        if(place==null) {
            log.error("place not found");
            return ResponseEntity.status(400).body("Sorry , not found!");
        }
        log.info("Got the place");
        return ResponseEntity.status(200).body(place);
    }

    @GetMapping("/getAllAccommodation/{placeName}")
    public ResponseEntity<?> getAllAccommodation(@PathVariable("placeName") String name){
        List<Accommodation> accommodations=accommodationService.getAllAccommodations(name);
        if(accommodations.size()==0) {
            log.error("No accommodations found here.");
            return ResponseEntity.status(400).body("No accommodations found here.");
        }
        log.info("got the accomodation");
        return ResponseEntity.status(200).body(accommodations);
    }

    @GetMapping("/getAllOffBeatPlaces/{placeName}")
    public ResponseEntity<?> getAllOffBeatPlaces(@PathVariable("placeName") String name){
        List<OffBeatPlaces> placesList=placeService.getAllOffBeatPlaces(name);
        if(placesList.size()==0) {
            log.error("No Offbeat places found !");
            return ResponseEntity.status(400).body("No places found here.");
        }
        log.info("got the offbeat places");
        return ResponseEntity.status(200).body(placesList);
    }

    @GetMapping("/getAllRestaurants/{placeName}")
    public ResponseEntity<?> getAllRestaurants(@PathVariable("placeName") String name){
        List<Restaurant> restaurantList=placeService.getAllRestaurants(name);
        if(restaurantList.size()==0) {
            log.error("No restaurants found here.");
            return ResponseEntity.status(400).body("No restaurants found here.");
        }
        log.info("found restaurants list");
        return ResponseEntity.status(200).body(restaurantList);
    }
    @GetMapping("/getAllActivitiesInaPlace/{offBeatId}")
    public ResponseEntity<?> getAllActivitiesInaPlace(@PathVariable("offBeatId") int offBeatId){
        List<Activities> activitiesList=placeService.getAllActivitiesInaPlace(offBeatId);
        if(activitiesList.size()==0) {
            log.error("No activities found here.");
            return ResponseEntity.status(400).body("No activities found here.");
        }
        log.info("activities found");
        return ResponseEntity.status(200).body(activitiesList);
    }

    @GetMapping("/getAllFoodsForaPlace/{placeName}")
    public ResponseEntity<?> getAllFoodsForaPlace(@PathVariable("placeName") String name){
        List<Foods> foodsList=placeService.getAllFoodsForaPlace(name);
        if(foodsList.size()==0) {
            log.error("No foods found here.");
            return ResponseEntity.status(400).body("No foods found here.");
        }
        log.info("found foodlist");
        return ResponseEntity.status(200).body(foodsList);
    }

    @GetMapping("/getAllReviews/{restaurantName}")
    public ResponseEntity<?> getAllReviews(@PathVariable("restaurantName") String restaurantName){
        List<RestaurantReviews> reviewsList=restaurantService.getAllReviews(restaurantName);
        if(reviewsList.size()==0) {
            log.error("No reviews found here.");
            return ResponseEntity.status(400).body("No reviews found here.");
        }
        log.info("found reviewsList");
        return ResponseEntity.status(200).body(reviewsList);
    }

    @GetMapping("/getAllPlaces/{regionName}")
    public ResponseEntity<?> getAllPlaces(@PathVariable("regionName") String regionName){
        List<Place> places=regionService.getAllPlaces(regionName);
        if(places.size()==0) {
            log.error("No places found for the region");
            return ResponseEntity.status(400).body("No places found for the region");
        }
        log.info("found all places for the region");
        return ResponseEntity.status(200).body(places);
    }

    @PostMapping("/addReviewForAccommodation")
    public ResponseEntity<String> addReviewForAccommodation(@RequestBody AccommodationReviews review){
        String str=accommodationService.addReviewsForRestaurant(review);
        if(str.equals("Added Successfully!"))
            log.info("review added successfully!");
        else
            log.error("review not added!");
        return ResponseEntity.status(200).body(str);
    }

    @GetMapping("/getHotelReviews/{hotelName}")
    public ResponseEntity<?> getHotelReviews(@PathVariable("hotelName") String hotelName){
        List<AccommodationReviews> reviewsList=accommodationService.getHotelReviews(hotelName);
        if(reviewsList.size()==0) {
            log.error("No reviews found here!");
            return ResponseEntity.status(400).body("No reviews found here.");
        }
        log.info("found all the reviews");
        return ResponseEntity.status(200).body(reviewsList);
    }

    @GetMapping("/getAllRegions")
    public ResponseEntity<List<Region>> getAllRegions(){
        List<Region> regionList=regionService.getAllRegions();
        if(regionList.size()==0){
            log.error("No regions found!");
            return ResponseEntity.status(400).body(regionList);
        }
        log.info("found all the regions!");
        return ResponseEntity.ok(regionList);
    }
}
