package com.example.tourguide.Controller;

import com.example.tourguide.Entity.*;
import com.example.tourguide.Service.AccommodationService;
import com.example.tourguide.Service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guide")
public class GuideController {

    private final PlaceService placeService;

    private final AccommodationService accommodationService;

    @PostMapping("/addPlace")
    public ResponseEntity<String> addPlace(@RequestBody Place place){
        String str=placeService.addPlace(place);
        return ResponseEntity.ok(str);
    }

    @GetMapping("/getPlace/{name}")
    public ResponseEntity<?> getPlace(@PathVariable("name") String name){
        Place place=placeService.getPlace(name);
        if(place==null)
            return ResponseEntity.status(400).body("Sorry , not found!");
        return ResponseEntity.status(200).body(place);
    }

    @PostMapping("/addAccommodation")
    public ResponseEntity<String> addAccommodation(@RequestBody Accommodation accommodation){
        String str=accommodationService.addAccommodation(accommodation);
        return ResponseEntity.ok(str);
    }

    @GetMapping("/getAllAccommodation/{placeName}")
    public ResponseEntity<?> getAllAccommodation(@PathVariable("placeName") String name){
        List<Accommodation> accommodations=accommodationService.getAllAccommodations(name);
        if(accommodations.size()==0)
            return ResponseEntity.status(400).body("No accommodations found here.");
        return ResponseEntity.status(200).body(accommodations);
    }


    @PostMapping("/addOffBeatPlace")
    public ResponseEntity<String> addOffBeatPlace(@RequestBody OffBeatPlaces place){
        String str=placeService.addOffBeatPlace(place);
        return ResponseEntity.ok(str);
    }

    @GetMapping("/getAllOffBeatPlaces/{placeName}")
    public ResponseEntity<?> getAllOffBeatPlaces(@PathVariable("placeName") String name){
        List<OffBeatPlaces> placesList=placeService.getAllOffBeatPlaces(name);
        if(placesList.size()==0)
            return ResponseEntity.status(400).body("No places found here.");
        return ResponseEntity.status(200).body(placesList);
    }

    @PostMapping("/addActivityForPlace")
    public ResponseEntity<String> addActivityForPlace(@RequestBody Activities activities){
        String str=placeService.addActivityForPlace(activities);
        return ResponseEntity.ok(str);
    }

    @GetMapping("/getAllActivitiesInaPlace/{offBeatId}")
    public ResponseEntity<?> getAllActivitiesInaPlace(@PathVariable("offBeatId") int offBeatId){
        List<Activities> activitiesList=placeService.getAllActivitiesInaPlace(offBeatId);
        if(activitiesList.size()==0)
            return ResponseEntity.status(400).body("No places found here.");
        return ResponseEntity.status(200).body(activitiesList);
    }

    @PostMapping("/addFoodsForPlace")
    public ResponseEntity<String> addFoodsForPlace(@RequestBody Foods foods){
        String str=placeService.addFoodForPlace(foods);
        return ResponseEntity.ok(str);
    }

    @GetMapping("/getAllFoodsForaPlace/{placeName}")
    public ResponseEntity<?> getAllFoodsForaPlace(@PathVariable("placeName") String name){
        List<Foods> foodsList=placeService.getAllFoodsForaPlace(name);
        if(foodsList.size()==0)
            return ResponseEntity.status(400).body("No places found here.");
        return ResponseEntity.status(200).body(foodsList);
    }
}
