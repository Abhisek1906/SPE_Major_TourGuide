package com.example.tourguide.Controller;

import com.example.tourguide.Entity.*;
import com.example.tourguide.Service.AccommodationService;
import com.example.tourguide.Service.PlaceService;
import com.example.tourguide.Service.RegionService;
import com.example.tourguide.Service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private static final ch.qos.logback.classic.Logger log= (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(UserController.class);

    private final PlaceService placeService;
    private final RestaurantService restaurantService;

    private final RegionService regionService;
    private final AccommodationService accommodationService;

    @PostMapping("/addPlace")
    public ResponseEntity<String> addPlace(@RequestBody Place place) {
        String str=placeService.addPlace(place);
        if(str.equals("Success!"))
            log.info("Place added successfully!");
        else
            log.error("Place not added");
        return ResponseEntity.ok(str);
    }

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

    @PostMapping("/addAccommodation")
    public ResponseEntity<String> addAccommodation(@RequestBody Accommodation accommodation){
        String str=accommodationService.addAccommodation(accommodation);
        if(str.equals("Success!"))
            log.info("Accommodation added successfully!");
        else
            log.error("Accommodation not added successfully!");
        return ResponseEntity.ok(str);
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


    @PostMapping("/addOffBeatPlace")
    public ResponseEntity<String> addOffBeatPlace(@RequestBody OffBeatPlaces place){
        String str=placeService.addOffBeatPlace(place);
        if(str.equals("Success!"))
            log.info("OffBeat place added successfully!");
        else
            log.error("OffBeat place not added successfully!");
        return ResponseEntity.ok(str);
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

    @PostMapping("/addActivityForPlace")
    public ResponseEntity<String> addActivityForPlace(@RequestBody Activities activities){
        String str=placeService.addActivityForPlace(activities);
        if(str.equals("Success!"))
            log.info("Activity added for a place");
        else
            log.error("Activity not added for a place");
        return ResponseEntity.ok(str);
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

    @PostMapping("/addFoodsForPlace")
    public ResponseEntity<String> addFoodsForPlace(@RequestBody Foods foods){
        String str=placeService.addFoodForPlace(foods);
        if(str.equals("Success!"))
            log.info("Foods added for a place");
        else
            log.error("Foods not added for a place");
        return ResponseEntity.ok(str);
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

    @PostMapping("/addRestaurantInAPlace")
    public ResponseEntity<String> addRestaurantInAPlace(@RequestBody Restaurant restaurant){
        String str=restaurantService.addRestaurant(restaurant);
        if(str.equals("Success!"))
            log.info("Restaurants added for a place");
        else
            log.error("Restaurants not added for a place");
        return ResponseEntity.status(200).body(str);
    }

    @PostMapping("/addReviewsForRestaurant")
    public ResponseEntity<String> addReviewsForRestaurant(@RequestBody RestaurantReviews reviews){
        String str=restaurantService.addReviewsForRestaurant(reviews);
        if(str.equals("Success!"))
            log.info("Reviews added for a place");
        else
            log.error("Reviews not added for a place");
        return ResponseEntity.status(200).body(str);
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

    @PostMapping("/addRegions")
    public ResponseEntity<String> addRegions(@RequestBody List<Region> regions){
        String str=regionService.addRegions(regions);
        return ResponseEntity.status(200).body(str);
    }


}
