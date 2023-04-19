package com.example.tourguide.Service;

import com.example.tourguide.Entity.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PlaceService {
    String addPlace(Place place);

    Place getPlace(String name);

    String addOffBeatPlace(OffBeatPlaces place);

    List<OffBeatPlaces> getAllOffBeatPlaces(String name);

    String addActivityForPlace(Activities activities);

    List<Activities> getAllActivitiesInaPlace(int offBeatId);

    String addFoodForPlace(Foods foods);

    List<Foods> getAllFoodsForaPlace(String name);

    List<Restaurant> getAllRestaurants(String name);
}
